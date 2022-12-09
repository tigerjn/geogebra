package org.geogebra.desktop.gui.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.geogebra.common.gui.util.SelectionTable;
import org.geogebra.common.main.GeoGebraColorConstants;
import org.geogebra.desktop.main.AppD;

/**
 * Creates a table to display and select images and other custom icons. The
 * table takes a one dimensional array of data objects as input and then, using
 * row and column size parameters, displays the data as GeoGebra icons in a 2D
 * table. User selection is returned as an index to the data array.
 * 
 * The table is intended for use in a popup menu.
 * 
 * @author G.Sturr
 * 
 */
public class SelectionTableD extends JTable {

	private static final long serialVersionUID = 1L;

	private AppD app;
	private SelectionTableCellRenderer renderer;
	private DefaultTableModel model;

	private int rollOverRow = -1;
	private int rollOverColumn = -1;

	private int sliderValue;

	private int horizontalAlignment = SwingConstants.LEFT;

	private boolean showSelection = true;

	public void setShowSelection(boolean showSelection) {
		this.showSelection = showSelection;
	}

	public void setHorizontalAlignment(int horizontalAlignment) {
		this.horizontalAlignment = horizontalAlignment;
	}

	private final Object[] data;
	private final int numRows;
	private final int numColumns;
	private int columnWidth;

	public int getColumnWidth() {
		return columnWidth;
	}

	private Dimension iconSize;

	private SelectionTable mode;

	boolean useColorSwatchBorder = false;

	/**
	 * @param useColorSwatchBorder to use border for swatch icons
	 */
	public void setUseColorSwatchBorder(boolean useColorSwatchBorder) {
		this.useColorSwatchBorder = useColorSwatchBorder;
		setCellDimensions();
	}

	private String[] toolTipArray = null;

	/**
	 * Sets the tooTip strings for the selection table; the toolTipArray should
	 * have a 1-1 correspondence with the data array
	 * 
	 * @param toolTipArray tooltips
	 */
	public void setToolTipArray(String[] toolTipArray) {
		this.toolTipArray = toolTipArray;
	}

	/********************************************************
	 * Constructor
	 * 
	 * @param app application
	 * @param data0 data
	 * @param rows0 number of rows
	 * @param columns0 number of  columns
	 * @param iconSize icon size
	 * @param mode selection type
	 */
	public SelectionTableD(AppD app, Object[] data0, int rows0, int columns0,
			Dimension iconSize, SelectionTable mode) {
		int columns = columns0;
		int rows = rows0;
		this.app = app;
		this.mode = mode;
		this.iconSize = iconSize;
		if (mode == SelectionTable.MODE_LATEX) {
			this.data = createLatexIconArray((String[]) data0);
		} else {
			this.data = data0;
		}

		// =======================================
		// determine the dimensions of the table

		// rows = -1, cols = -1 ==> square table to fit data
		if (rows == -1 && columns == -1) {
			rows = (int) Math.floor(Math.sqrt(data.length));
			columns = (int) Math.ceil(data.length / (double) rows);
		}

		// rows = -1 ==> fixed cols, rows added to fit data
		else if (rows == -1) {
			rows = (int) (Math.ceil(data.length / (double) columns));
		}

		// cols = -1 ==> fixed rows, cols added to fit data
		else if (columns == -1) {
			columns = (int) (Math.ceil(data.length / (double) rows));
		}

		numRows = rows;
		numColumns = columns;

		// =======================================

		// set the table model with the data
		populateModel(data);

		// =======================================
		// set cell renderer
		renderer = new SelectionTableCellRenderer();
		this.setDefaultRenderer(Object.class, renderer);

		// =======================================
		// set various display properties
		this.setAutoResizeMode(AUTO_RESIZE_OFF);
		this.setAutoCreateColumnsFromModel(false);
		setShowGrid(false);
		setGridColor(Color.GRAY);
		this.setTableHeader(null);
		this.setBorder(null);
		setCellDimensions();
		setFont(app.getPlainFont());
		setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// set cell selection properties
		setCellSelectionEnabled(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// =======================================
		// add listener for mouse roll over
		RollOverListener rollOverListener = new RollOverListener();
		addMouseMotionListener(rollOverListener);
		addMouseListener(rollOverListener);

	}

	/** Disables cell editing */
	@Override
	public boolean isCellEditable(int rowIndex, int vColIndex) {
		return false;
	}

	/** Loads a one dimensional array of data into the table model */
	public void populateModel(Object[] data1) {

		model = new DefaultTableModel(numRows, numColumns);
		int r = 0;
		int c = 0;

		for (int i = 0; i < Math.min(data1.length,
				this.numRows * this.numColumns); i++) {
			model.setValueAt(data1[i], r, c);
			++c;
			if (c == this.numColumns) {
				c = 0;
				++r;
			}
		}

		setModel(model);
	}

	private ImageIcon[] createLatexIconArray(String[] symbols) {
		ImageIcon[] iconArray = new ImageIcon[symbols.length];
		for (int i = 0; i < symbols.length; i++) {
			iconArray[i] = GeoGebraIconD.createLatexIcon(app, symbols[i],
					app.getPlainFont(), Color.BLACK, null);
		}
		return iconArray;
	}

	// set cell dimensions
	private void setCellDimensions() {

		int padding = useColorSwatchBorder ? 1 : 4;

		// match row height to specified icon height
		// when mode=text then let font size adjust row height automatically
		int rowHeight;
		if (!(mode == SelectionTable.MODE_TEXT
				|| mode == SelectionTable.MODE_LATEX)) {
			rowHeight = iconSize.height + padding;
		} else {
			rowHeight = getMaxRowHeight(this) + padding;
		}

		setRowHeight(rowHeight);

		// set the column widths
		columnWidth = iconSize.width + padding;
		int w;
		for (int i = 0; i < getColumnCount(); ++i) {
			// for mode=text, adjust column width to the maximum width in the
			// column
			if (mode == SelectionTable.MODE_TEXT
					|| mode == SelectionTable.MODE_LATEX) {
				w = getMaxColumnWidth(this, i);
				getColumnModel().getColumn(i).setPreferredWidth(w);
				columnWidth = Math.max(w, columnWidth);
			} else {
				getColumnModel().getColumn(i).setPreferredWidth(columnWidth);
			}

		}
		repaint();
	}

	/**
	 * Update fonts
	 */
	public void updateFonts() {
		setFont(app.getPlainFont());
		setCellDimensions();
	}

	// ==============================================
	// Listeners
	// ==============================================

	private class RollOverListener extends MouseInputAdapter {

		@Override
		public void mouseExited(MouseEvent e) {
			rollOverRow = -1;
			rollOverColumn = -1;
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			int row = rowAtPoint(e.getPoint());
			int column = columnAtPoint(e.getPoint());
			if (row != rollOverRow || column != rollOverColumn) {
				rollOverRow = row;
				rollOverColumn = column;

				if (toolTipArray != null) {
					int index = getColumnCount() * row + column;
					if (index < data.length) {
						setToolTipText(toolTipArray[index]);
					} else {
						setToolTipText(null);
					}
				}
				repaint();
			}
		}
	}

	// ==============================================
	// Getters/Setters
	// ==============================================

	/**
	 * @return selected index
	 */
	public int getSelectedIndex() {
		int index = this.getColumnCount() * this.getSelectedRow()
				+ this.getSelectedColumn();
		if (index < -1) {
			index = -1;
		}
		return index;
	}

	/**
	 * Select a cell
	 * @param index cell index
	 */
	public void setSelectedIndex(int index) {
		if (index == -1) {
			this.clearSelection();
			return;
		}
		int row = index / getColumnCount();
		int column = index - (row * getColumnCount());
		this.changeSelection(row, column, false, false);
		rollOverRow = -1;
		rollOverColumn = -1;
	}

	/**
	 * @return selected value
	 */
	public Object getSelectedValue() {
		if (getSelectedRow() != -1 && getSelectedColumn() != -1) {
			return model.getValueAt(getSelectedRow(), getSelectedColumn());
		}
		return null;
	}

	public int getSliderValue() {
		return sliderValue;
	}

	public void setSliderValue(int sliderValue) {
		this.sliderValue = sliderValue;
	}

	public Object[] getData() {
		return data;
	}

	/**
	 * @param value value
	 * @return icon value as icon or null
	 */
	public ImageIcon getDataIcon(Object value) {
		ImageIcon icon = null;
		if (value == null) {
			return GeoGebraIconD.createEmptyIcon(1, 1);
		}

		switch (mode) {

		default:
			// do nothing
			break;
		case MODE_ICON:
		case MODE_LATEX:
			icon = (ImageIcon) value;
			break;

		}

		return icon;
	}

	// ==============================================
	// Cell Renderer
	// ==============================================

	class SelectionTableCellRenderer extends JLabel implements TableCellRenderer {

		private static final long serialVersionUID = 1L;

		private final Border normalBorder;
		private final Border selectedBorder;
		private final Border rollOverBorder;
		private final Border paddingBorder;
		private final Color selectionColor;
		private final Color rollOverColor;

		public SelectionTableCellRenderer() {

			// TODO --- selection color should be centralized, not from
			// spreadsheet

			selectionColor = org.geogebra.desktop.awt.GColorD.getAwtColor(
					GeoGebraColorConstants.TABLE_SELECTED_BACKGROUND_COLOR);
			rollOverColor = Color.LIGHT_GRAY;

			paddingBorder = BorderFactory.createEmptyBorder(0, 5, 0, 5);

			rollOverBorder = BorderFactory.createLineBorder(Color.GRAY, 3);
			normalBorder = BorderFactory.createLineBorder(Color.GRAY, 1);
			if (mode == SelectionTable.MODE_LATEX) {
				selectedBorder = rollOverBorder;
			} else {
				selectedBorder = BorderFactory.createLineBorder(Color.BLACK, 3);
			}

			setOpaque(true);
			setHorizontalAlignment(CENTER);
			setVerticalAlignment(CENTER);

		}

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			setAlignmentX(CENTER_ALIGNMENT);
			setAlignmentY(CENTER_ALIGNMENT);

			if (mode == SelectionTable.MODE_TEXT) {
				this.setHorizontalAlignment(horizontalAlignment);
				this.setVerticalAlignment(SwingConstants.CENTER);
				setText((String) value);
				setFont(app.getFontCanDisplayAwt((String) value, Font.PLAIN));
				setBorder(paddingBorder);

			} else {
				setText("");
				setIcon(getDataIcon(value));
			}

			if (useColorSwatchBorder) {
				setBackground(table.getBackground());
				if (showSelection && isSelected) {
					setBorder(selectedBorder);
				} else if (row == rollOverRow && column == rollOverColumn) {
					setBorder(rollOverBorder);
				} else {
					setBorder(normalBorder);
				}

			} else {

				if (showSelection && isSelected) {
					setBackground(selectionColor);
				} else if (row == rollOverRow && column == rollOverColumn) {
					setBackground(rollOverColor);
				} else {
					setBackground(table.getBackground());
				}
			}

			return this;
		}
	}

	/**
	 * Finds the maximum preferred width of a column.
	 * @return maximum column width
	 */
	public int getMaxColumnWidth(JTable table, int column) {

		// iterate through the rows and find the preferred width
		int maxPrefWidth = 0;
		int colPrefWidth = 0;
		for (int row = 0; row < table.getRowCount(); row++) {
			if (table.getValueAt(row, column) != null) {
				colPrefWidth = (int) table.getCellRenderer(row, column)
						.getTableCellRendererComponent(table,
								table.getValueAt(row, column), false, false,
								row, column)
						.getPreferredSize().getWidth();
				maxPrefWidth = Math.max(maxPrefWidth, colPrefWidth);
			}
		}

		return maxPrefWidth + table.getIntercellSpacing().width;
	}

	/**
	 * Finds the maximum preferred height of all cells.
	 * @return maximum row height
	 */
	public int getMaxRowHeight(JTable table) {

		// iterate through all cells
		int maxPrefHeight = 0;
		int cellPrefHeight = 0;
		for (int r = 0; r < table.getRowCount(); r++) {
			for (int c = 0; c < table.getColumnCount(); c++) {
				if (table.getValueAt(r, c) != null) {
					cellPrefHeight = (int) table.getCellRenderer(r, c)
							.getTableCellRendererComponent(table,
									table.getValueAt(r, c), false, false, r, c)
							.getPreferredSize().getHeight();
					maxPrefHeight = Math.max(maxPrefHeight, cellPrefHeight);
				}
			}
		}
		return maxPrefHeight + table.getIntercellSpacing().height;
	}

}

package org.geogebra.keyboard.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.geogebra.common.euclidian.event.PointerEventType;
import org.geogebra.common.keyboard.KeyboardRowDefinitionProvider;
import org.geogebra.common.main.AppKeyboardType;
import org.geogebra.common.main.Localization;
import org.geogebra.common.util.lang.Language;
import org.geogebra.keyboard.base.Accents;
import org.geogebra.keyboard.base.Action;
import org.geogebra.keyboard.base.Keyboard;
import org.geogebra.keyboard.base.KeyboardFactory;
import org.geogebra.keyboard.base.KeyboardType;
import org.geogebra.keyboard.base.Resource;
import org.geogebra.keyboard.base.model.Row;
import org.geogebra.keyboard.base.model.WeightedButton;
import org.geogebra.keyboard.scientific.factory.ScientificKeyboardFactory;
import org.geogebra.keyboard.web.factory.InputBoxKeyboardFactory;
import org.geogebra.keyboard.web.factory.NotesKeyboardFactory;
import org.geogebra.web.html5.gui.util.BrowserStorage;
import org.geogebra.web.resources.SVGResource;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;
import com.himamis.retex.editor.share.util.Unicode;

/**
 * tabbed keyboard
 */
public class TabbedKeyboard extends FlowPanel
		implements ButtonHandler, RequiresResize {

	/**
	 * small height
	 */
	public static final int SMALL_HEIGHT = 131;
	/**
	 * big height
	 */
	public static final int BIG_HEIGHT = 186;

	/**
	 * minimum width of the whole application to use normal font (small font
	 * otherwise)
	 */
	protected static final int MIN_WIDTH_FONT = 485;

	/**
	 * base width
	 */
	protected static final int BASE_WIDTH = 70;
	/**
	 * localization
	 */
	Localization locale;
	private boolean isSmallKeyboard;
	/**
	 * application
	 */
	protected HasKeyboard hasKeyboard;
	private final ArrayList<Keyboard> layouts = new ArrayList<>(4);
	private String keyboardLocale;
	private UpdateKeyBoardListener updateKeyBoardListener;
	protected KeyboardListener processField;
	private FlowPanel tabs;
	protected KeyboardSwitcher switcher;
	private final Map<KeyboardType, Widget> keyboardMap;
	private KeyboardFactory factory;
	/**
	 * true if keyboard wanted
	 */
	protected boolean keyboardWanted = false;
	private ButtonRepeater repeater;
	private final boolean hasMoreButton;

	private KeyboardSwitcher.SwitcherButton ansSwitcher;
	private KeyboardSwitcher.SwitcherButton defaultSwitcher;

	/**
	 * @param appKeyboard
	 *            {@link HasKeyboard}
	 * @param hasMoreButton
	 *            whether to show help button
	 */
	public TabbedKeyboard(HasKeyboard appKeyboard, boolean hasMoreButton) {
		this.hasKeyboard = appKeyboard;
		this.locale = hasKeyboard.getLocalization();
		this.keyboardLocale = locale.getLocaleStr();
		this.switcher = new KeyboardSwitcher(this);
		this.hasMoreButton = hasMoreButton;
		this.keyboardMap = new HashMap<>();
	}

	/**
	 * @return {@link UpdateKeyBoardListener}
	 */
	public UpdateKeyBoardListener getUpdateKeyBoardListener() {
		return updateKeyBoardListener;
	}

	/**
	 * @param listener
	 *            {@link UpdateKeyBoardListener}
	 */
	public void setListener(UpdateKeyBoardListener listener) {
		this.updateKeyBoardListener = listener;
	}

	/**
	 * on close
	 */
	protected void closeButtonClicked() {
		if (updateKeyBoardListener != null) {
			updateKeyBoardListener.keyBoardNeeded(false, null);
		}
		keyboardWanted = false;
		BrowserStorage.LOCAL.setItem(BrowserStorage.KEYBOARD_WANTED, "false");
	}

	private KeyboardFactory initKeyboardFactory() {
		KeyboardFactory factory;
		if (hasKeyboard.getInputBoxType() != null) {
			factory = new InputBoxKeyboardFactory(hasKeyboard.getInputBoxType(),
					hasKeyboard.getInputBoxFunctionVars());
		} else {
			if (hasKeyboard.getKeyboardType() == AppKeyboardType.NOTES) {
				factory = NotesKeyboardFactory.INSTANCE;
			} else if (hasKeyboard.getKeyboardType() == AppKeyboardType.SCIENTIFIC
				|| hasKeyboard.getKeyboardType() == AppKeyboardType.SOLVER) {
				factory = ScientificKeyboardFactory.INSTANCE;
			} else {
				factory = KeyboardFactory.INSTANCE;
			}
		}
		return factory;
	}

	private void buildGUIGgb() {
		// more button must be first because of float (Firefox)
		if (hasMoreButton) {
			switcher.addMoreButton();
		}

		createAnsMathKeyboard();
		createDefaultKeyboard();
		createFunctionsKeyboard();
		if (locale.isLatinKeyboard()) {
			createLocalizedAbcKeyboard(true);
		} else {
			createLatinKeyboard(factory);
			createLocalizedAbcKeyboard(false);
		}
		createSpecialSymbolsKeyboard(factory);
		createGreekKeyboard(factory);

		switcher.select(KeyboardType.NUMBERS);
		layout();
	}

	private void buildGUIScientific() {
		createAnsMathKeyboard();
		createDefaultKeyboard();
		createFunctionsKeyboard();
		createLocalizedAbcKeyboard(false);
		switcher.select(KeyboardType.NUMBERS);
		layout();
	}

	private void createAnsMathKeyboard() {
		KeyPanelBase keyboard = buildPanel(factory.createMathKeyboard());
		addTab(keyboard, KeyboardType.NUMBERS);
		ansSwitcher = switcher.addSwitch(keyboard, KeyboardType.NUMBERS, "123");
		ansSwitcher.setVisible(false);
		setDataTest(ansSwitcher, "keyboard-123-ans");
	}

	private void createFunctionsKeyboard() {
		KeyPanelBase functionKeyboard = buildPanel(factory.createFunctionsKeyboard());
		addTab(functionKeyboard, KeyboardType.OPERATORS);
		functionKeyboard.setVisible(false);
		KeyboardSwitcher.SwitcherButton function = switcher.addSwitch(functionKeyboard,
				KeyboardType.OPERATORS, "f(x)");
		setDataTest(function, "keyboard-fx");
	}

	private void createDefaultKeyboard() {
		KeyPanelBase defaultKeyboard = buildPanel(factory.createDefaultKeyboard());
		addTab(defaultKeyboard, KeyboardType.NUMBERS_DEFAULT);
		defaultKeyboard.setVisible(false);
		defaultSwitcher = switcher.addSwitch(defaultKeyboard, KeyboardType.NUMBERS_DEFAULT, "123");
		setDataTest(defaultSwitcher, "keyboard-123");
	}

	private void createLocalizedAbcKeyboard(boolean withGreek) {
		KeyboardRowDefinitionProvider krp = new KeyboardRowDefinitionProvider(locale);
		String[] lowerKeys = krp.getLowerKeys();
		Keyboard letterKeyboard = factory.createLettersKeyboard(lowerKeys[0],
				lowerKeys[1],
				lowerKeys[2], krp.getUpperKeys(), withGreek);

		KeyPanelBase keyboard = buildPanel(letterKeyboard);
		addTab(keyboard, KeyboardType.ABC);
		keyboard.setVisible(false);
		switcher.addSwitch(keyboard, KeyboardType.ABC,
				locale.getMenuDefault("Keyboard.ABC", "ABC"));
	}

	private void createSpecialSymbolsKeyboard(KeyboardFactory factory) {
		KeyPanelBase keyboard = buildPanel(factory.createSpecialSymbolsKeyboard());
		addTab(keyboard, KeyboardType.SPECIAL);
		keyboard.setVisible(false);
		switcher.addSwitch(keyboard, KeyboardType.SPECIAL,
				KeyboardConstants.SWITCH_TO_SPECIAL_SYMBOLS);
	}

	private void createGreekKeyboard(KeyboardFactory factory) {
		KeyPanelBase keyboard = buildPanel(factory.createGreekKeyboard());
		keyboard.setVisible(false);
		addTab(keyboard, KeyboardType.GREEK);
	}

	private void createLatinKeyboard(KeyboardFactory factory) {
		KeyboardRowDefinitionProvider latinProvider = new KeyboardRowDefinitionProvider(
				locale);
		String[] rows = latinProvider.getDefaultLowerKeys();
		Keyboard keyboardModel = factory.createLettersKeyboard(rows[0], rows[1],
				rows[2], latinProvider.getUpperKeys());
		KeyPanelBase keyboard = buildPanel(keyboardModel);
		addTab(keyboard, KeyboardType.LATIN);
		keyboard.setVisible(false);
		switcher.addSwitch(keyboard, KeyboardType.LATIN, "ABC");
	}

	private void addTab(KeyPanelBase keyboardPanel, KeyboardType keyboardType) {
		tabs.add(keyboardPanel);
		keyboardMap.put(keyboardType, keyboardPanel);
	}

	private void setDataTest(Widget widget, String value) {
		widget.getElement().setAttribute("data-test", value);
	}

	private void layout() {
		add(switcher);
		add(tabs);
		addStyleName("KeyBoard");
		addStyleName("TabbedKeyBoard");
		addStyleName("gwt-PopupPanel");
	}

	private KeyPanelBase buildPanel(Keyboard layout) {
		final KeyPanelBase keyboard = new KeyPanelBase(layout);
		layouts.add(layout);
		keyboard.addStyleName("KeyPanel");
		keyboard.addStyleName("normal");
		updatePanel(keyboard, layout);
		layout.registerKeyboardObserver(l2 -> updatePanel(keyboard, l2));
		return keyboard;
	}

	/**
	 * 
	 * @param maxWeightSum
	 *            weight sum of the widest row
	 * @return button base size
	 */
	int getBaseSize(double maxWeightSum) {
		return (int) ((hasKeyboard.getInnerWidth() - 10) > BASE_WIDTH * maxWeightSum
				? BASE_WIDTH : (hasKeyboard.getInnerWidth() - 10) / maxWeightSum);
	}

	/**
	 * @param keyboard
	 *            {@link KeyPanelBase}
	 * @param layout
	 *            {@link Keyboard}
	 */
	void updatePanel(KeyPanelBase keyboard, Keyboard layout) {
		keyboard.reset(layout);
		int index = 0;
		for (Row row : layout.getModel().getRows()) {
			for (WeightedButton wb : row.getButtons()) {
				if (!Action.NONE.name().equals(wb.getPrimaryActionName())) {
					KeyBoardButtonBase button = makeButton(wb);
					addSecondary(button, wb);
					keyboard.addToRow(index, button);
				}
			}
			index++;
		}
		updatePanelSize(keyboard);
	}

	/**
	 * This is much faster than updatePanel as it doesn't clear the model. It
	 * assumes the model and button layout are in sync.
	 */
	private void updatePanelSize(KeyPanelBase keyboard) {
		int buttonIndex = 0;
		int margins = 4;
		if (keyboard.getLayout() == null) {
			return;
		}
		KeyBoardButtonBase button = null;
		double weightSum = 6; // initial guess
		for (Row row : keyboard.getLayout().getModel().getRows()) {
			weightSum = Math.max(row.getRowWeightSum(), weightSum);
		}
		int baseSize = getBaseSize(weightSum);
		for (Row row : keyboard.getLayout().getModel().getRows()) {
			double offset = 0;
			for (WeightedButton wb : row.getButtons()) {
				if (Action.NONE.name().equals(wb.getPrimaryActionName())) {
					offset = wb.getWeight();
				} else {
					button = keyboard.getButtons().get(buttonIndex);
					if (offset > 0) {
						button.getElement().getStyle().setMarginLeft(
								offset * baseSize + margins / 2d, Unit.PX);
					}
					button.getElement().getStyle().setWidth(
							wb.getWeight() * baseSize - margins, Unit.PX);
					offset = 0;
					buttonIndex++;
				}
			}
			if (Action.NONE.name().equals(row.getButtons()
					.get(row.getButtons().size() - 1).getPrimaryActionName())) {
				button.getElement().getStyle().setMarginRight(
						offset * baseSize + margins / 2d, Unit.PX);
			}
		}
		if (hasKeyboard.getInnerWidth() < getMinWidthWithoutScaling()) {
			addStyleName("scale");
			removeStyleName("normal");
			removeStyleName("smallerFont");
			if (hasKeyboard.getInnerWidth() < MIN_WIDTH_FONT) {
				addStyleName("smallerFont");
			}
		} else {
			addStyleName("normal");
			removeStyleName("scale");
			removeStyleName("smallerFont");
		}
		// set width of switcher contents
		if (hasKeyboard.getInnerWidth() > 700) {
			switcher.getContent().getElement().getStyle().setWidth(644,
					Unit.PX);
		} else {
			switcher.getContent().getElement().getStyle()
					.setWidth(Math.min(644, hasKeyboard.getInnerWidth() - 10), Unit.PX);
		}
	}

	private KeyBoardButtonBase makeButton(WeightedButton wb) {
		ButtonHandler b = this;
		switch (wb.getResourceType()) {
		case TRANSLATION_MENU_KEY:
			if (wb.getResourceName().equals("Translate.currency")) {
				return new KeyBoardButtonBase(
						Language.getCurrency(keyboardLocale),
						Language.getCurrency(keyboardLocale), b);
			}

			final String name = wb.getPrimaryActionName();

			String altText = wb.getAltText();
			if (altText == null || altText.isEmpty()) {
				altText = name;
			} else {
				// eg "inverse sine"
				altText = locale.getAltText(wb.getAltText());
			}
			return new KeyBoardButtonBase(locale.getFunction(name), altText,
					name, b);
		case TRANSLATION_COMMAND_KEY:
			return new KeyBoardButtonBase(
					locale.getCommand(wb.getPrimaryActionName()),
					wb.getPrimaryActionName(), b);
		case DEFINED_CONSTANT:
			return functionButton(wb);
		case TEXT:
		default:
			return textButton(wb, b);
		}
	}

	private static void addSecondary(KeyBoardButtonBase btn,
			WeightedButton wb) {
		if (wb.getActionsSize() > 1) {
			btn.setSecondaryAction(wb.getActionName(1));
		}
	}

	private KeyBoardButtonBase textButton(WeightedButton wb, ButtonHandler b) {
		String name = wb.getPrimaryActionName();
		if (name.equals(Action.TOGGLE_ACCENT_ACUTE.name())) {
			return accentButton(Accents.ACCENT_ACUTE, Action.TOGGLE_ACCENT_ACUTE, b);
		}
		if (name.equals(Action.TOGGLE_ACCENT_CARON.name())) {
			return accentButton(Accents.ACCENT_CARON, Action.TOGGLE_ACCENT_CARON, b);
		}
		if (name.equals(Action.TOGGLE_ACCENT_CIRCUMFLEX.name())) {
			return accentButton(Accents.ACCENT_CIRCUMFLEX, Action.TOGGLE_ACCENT_CIRCUMFLEX, b);
		}
		if (name.equals(Action.TOGGLE_ACCENT_GRAVE.name())) {
			return accentButton(Accents.ACCENT_GRAVE, Action.TOGGLE_ACCENT_GRAVE, b);
		}
		if ((Unicode.DIVIDE + "").equals(name)) {
			// division button in scientific
			return new KeyBoardButtonBase(Unicode.DIVIDE + "", "/", b);
		}
		if ("/".equals(name)) {
			// division button in graphing
			return new KeyBoardButtonBase(wb.getResourceName(), "/", b);
		}
		if ("|".equals(name)) {
			return new KeyBoardButtonBase("abs", "abs", b);
		}
		if ("-".equals(name)) {
			return new KeyBoardButtonBase(Unicode.MINUS + "", b);
		}
		if (name.equals(Action.ANS.name())) {
			return new KeyBoardButtonFunctionalBase("ans", this, Action.ANS);
		}
		if (name.equals(Action.SWITCH_TO_SPECIAL_SYMBOLS.name())) {
			return new KeyBoardButtonFunctionalBase(
					KeyboardConstants.SWITCH_TO_SPECIAL_SYMBOLS, this,
					Action.SWITCH_TO_SPECIAL_SYMBOLS);
		}
		if (name.equals(Action.SWITCH_TO_GREEK_CHARACTERS.name())) {
			return new KeyBoardButtonFunctionalBase(
					KeyboardConstants.SWITCH_TO_GREEK_CHARACTERS, this,
					Action.SWITCH_TO_GREEK_CHARACTERS);
		}
		if (name.equals(Action.SWITCH_TO_ABC.name())) {
			return new KeyBoardButtonFunctionalBase("ABC", this,
					Action.SWITCH_TO_ABC);
		}

		String caption = wb.getResourceName();
		String altText = wb.getAltText();

		if (altText == null || altText.isEmpty()) {
			// default behaviour for most keys
			altText = name;
		} else if (altText.startsWith("altText.")) {
			// translate if necessary
			// eg altText.imaginaryi
			altText = locale.getAltText(altText);
		}

		return new KeyBoardButtonBase(caption, altText, name, b);
	}

	private static KeyBoardButtonBase accentButton(String accent, Action action,
			ButtonHandler b) {
		return new KeyBoardButtonFunctionalBase(accent, b, action);
	}

	/**
	 * process shift
	 */
	protected void processShift() {
		for (Keyboard layout : layouts) {
			layout.toggleCapsLock();
		}
	}

	/**
	 * turn off capslock
	 */
	protected void disableCapsLock() {
		for (Keyboard layout : layouts) {
			layout.disableCapsLock();
		}
	}

	/**
	 * @param text
	 *            letter
	 */
	protected void processAccent(String text) {
		for (Keyboard layout : layouts) {
			layout.toggleAccent(text);
		}
	}

	private KeyBoardButtonBase functionButton(WeightedButton button) {
		Localization loc = hasKeyboard.getLocalization();
		String resourceName = button.getResourceName();
		ButtonHandler bh = this;
		Resource resource = Resource.EMPTY_IMAGE;
		try {
			resource = Resource.valueOf(resourceName);
		} catch (RuntimeException re) {
			// not in enum
		}
		switch (resource) {
		case RETURN_ENTER:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_enter_black(), bh,
					Action.RETURN_ENTER, loc, resource.altText);
		case BACKSPACE_DELETE:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_backspace(), bh,
					Action.BACKSPACE_DELETE, loc, resource.altText);
		case LEFT_ARROW:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_arrowLeft_black(), bh,
					Action.LEFT_CURSOR, loc, resource.altText);
		case RIGHT_ARROW:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_arrowRight_black(), bh,
					Action.RIGHT_CURSOR, loc, resource.altText);
		case DOWN_ARROW:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_arrowDown_black(), bh,
					Action.DOWN_CURSOR, loc, resource.altText);
		case UP_ARROW:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_arrowUp_black(), bh,
					Action.UP_CURSOR, loc, resource.altText);
		case FRACTION:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.fraction(),
					"/", bh, loc,
					resource.altText);
		case CAPS_LOCK:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_shift(), bh,
					Action.CAPS_LOCK, loc, resource.altText);
		case CAPS_LOCK_ENABLED:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.keyboard_shiftDown(), bh,
					Action.CAPS_LOCK, loc, resource.altText);
		case LOG_10:
			return new KeyBoardButtonBase("log_10",
					loc.getAltText(resource.altText),
					button.getPrimaryActionName(), bh);
		case A_N:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.subscript(),
					"_", bh, loc, resource.altText);
		case INTEGRAL:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.integral(),
					button.getPrimaryActionName(), bh, loc, resource.altText);
		case DERIVATIVE:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.derivative(),
					button.getPrimaryActionName(), bh, loc, resource.altText);
		case ABS:
			return new KeyBoardButtonFunctionalBase(
					KeyboardResources.INSTANCE.abs(),
					"abs", bh, loc, resource.altText);
		}

		SVGResource svg = getSvg(resource);
		if (svg != null) {
			return new KeyBoardButtonFunctionalBase(
					svg, button.getPrimaryActionName(),
					this, loc, resource.altText);
		}
		return new KeyBoardButtonBase(button.getPrimaryActionName(),
				button.getPrimaryActionName(), bh);
	}

	private SVGResource getSvg(Resource keyboardResource) {
		switch (keyboardResource) {
		case POWA2:
			return KeyboardResources.INSTANCE.square();
		case INVERSE:
			return KeyboardResources.INSTANCE.inverse();
		case POWAB:
			return KeyboardResources.INSTANCE.power();
		case POW10_X:
			return KeyboardResources.INSTANCE.ten_power();
		case POWE_X:
			return KeyboardResources.INSTANCE.e_power();
		case N_ROOT:
			return KeyboardResources.INSTANCE.n_root();
		case LOG_B:
			return KeyboardResources.INSTANCE.log();
		case CEIL:
			return KeyboardResources.INSTANCE.ceil();
		case FLOOR:
			return KeyboardResources.INSTANCE.floor();
		case DEFINITE_INTEGRAL:
			return KeyboardResources.INSTANCE.definite_integral();
		case LIM:
			return KeyboardResources.INSTANCE.lim();
		case PRODUCT:
			return KeyboardResources.INSTANCE.product();
		case SUM:
			return KeyboardResources.INSTANCE.sum();
		case VECTOR:
			return KeyboardResources.INSTANCE.vector();
		case ATOMIC_POST:
			return KeyboardResources.INSTANCE.atomic_post();
		case ATOMIC_PRE:
			return KeyboardResources.INSTANCE.atomic_pre();
		case ROOT:
			return KeyboardResources.INSTANCE.sqrt();
		case MIXED_NUMBER:
			return KeyboardResources.INSTANCE.mixed_number();
		default: return null;
		}
	}

	@Override
	public void onResize() {
		if (hasKeyboard.getInnerWidth() < 0) {
			return;
		}
		// -2 for applet border
		setWidth(hasKeyboard.getInnerWidth() + "px");
		boolean shouldBeSmall = hasKeyboard.needsSmallKeyboard();
		if (shouldBeSmall && !isSmallKeyboard) {
			addStyleName("lowerHeight");
			this.isSmallKeyboard = true;
		} else if (!shouldBeSmall && isSmallKeyboard) {
			removeStyleName("lowerHeight");
			this.isSmallKeyboard = false;
		}
		updateHeight();
		for (int i = 0; tabs != null && i < tabs.getWidgetCount(); i++) {
			Widget wdgt = tabs.getWidget(i);
			if (wdgt instanceof KeyPanelBase) {
				updatePanelSize((KeyPanelBase) wdgt);
			}
		}
	}

	private void updateHeight() {
		if (hasKeyboard != null) {
			hasKeyboard.updateKeyboardHeight();
		}
	}

	/**
	 * loads the translation-files for the active language if it is different
	 * from the last loaded language and sets the {@link Localization} to the
	 * new language
	 */
	public void checkLanguage() {
		switcher.reset();

		// TODO validate?
		String newKeyboardLocale = hasKeyboard.getLocalization().getLocaleStr();
		if ((newKeyboardLocale != null
				&& newKeyboardLocale.equals(keyboardLocale)) || factory == null) {
			return;
		}

		switcher.clear();
		switcher.setup();
		if (newKeyboardLocale != null) {
			this.keyboardLocale = newKeyboardLocale;
		} else {
			this.keyboardLocale = Language.English_US.getLocaleGWT();
		}

		clear();
		buildGUI();
	}

	/**
	 * rebuilds the keyboard layout based on the inputbox type
	 */
	public void clearAndUpdate() {
		KeyboardFactory newFactory = initKeyboardFactory();
		if (Objects.equals(factory, newFactory)) {
			return;
		} else {
			factory = newFactory;
		}

		switcher.clear();
		switcher.setup();
		clear();
		buildGUI();
	}

	/**
	 * (Re)build the UI.
	 */
	public void buildGUI() {
		this.tabs = new FlowPanel();
		if (hasKeyboard.getKeyboardType() == AppKeyboardType.SCIENTIFIC) {
			buildGUIScientific();
		} else {
			buildGUIGgb();
		}
	}

	@Override
	public void setVisible(boolean b) {
		switcher.reset();
		super.setVisible(b);
	}

	/**
	 * @param x
	 *            coord
	 * @param y
	 *            coord
	 */
	protected void toggleHelp(int x, int y) {
		// do nothing
	}

	/**
	 * @param keyboardType
	 *            keyboard type
	 */
	public void selectTab(KeyboardType keyboardType) {
		clearAndUpdate();
		switcher.select(keyboardType);
	}

	/**
	 * Get keyboard panel.
	 *
	 * @param keyboardType type of the keyboard
	 * @return panel
	 */
	public Widget getKeyboard(KeyboardType keyboardType) {
		return keyboardMap.get(keyboardType);
	}

	/**
	 * Width of ABC panel is 10 * 70 + 82 (70 = width of button; 82 = padding)
	 * Width of numbers panel is 850.
	 */
	private static int getMinWidthWithoutScaling() {
		return 850;
	}

	/**
	 * @return true if keyboard wanted
	 */
	public final boolean shouldBeShown() {
		return this.keyboardWanted;
	}

	/**
	 * keyboard wanted in focus
	 */
	public final void showOnFocus() {
		this.keyboardWanted = true;
	}

	/**
	 * Hide all keyboard panels.
	 */
	public void hideKeyboards() {
		for (int i = 0; i < tabs.getWidgetCount(); i++) {
			tabs.getWidget(i).setVisible(false);
		}
	}

	/**
	 * Stop editing.
	 */
	public void endEditing() {
		if (processField != null) {
			processField.endEditing();
		}
	}

	/**
	 * @param field
	 *            editor listening to KB events
	 */
	public void setProcessing(KeyboardListener field) {
		if (processField != null && processField.getField() != null) {
			if (field == null || processField.getField() != field.getField()) {
				endEditing();
			}
		}
		this.processField = field;
		updateKeyboard();
	}

	private void updateKeyboard() {
		if (processField == null || ansSwitcher == null) {
			return;
		}
		boolean requestsAns = processField.requestsAns();
		ansSwitcher.setVisible(requestsAns);
		defaultSwitcher.setVisible(!requestsAns);
		if (requestsAns && switcher.isSelected(defaultSwitcher)) {
			setSelected(ansSwitcher, true);
			setSelected(defaultSwitcher, false);
		} else if (!requestsAns && switcher.isSelected(ansSwitcher)) {
			setSelected(ansSwitcher, false);
			setSelected(defaultSwitcher, true);
		}
	}

	private void setSelected(KeyboardSwitcher.SwitcherButton btn, boolean selected) {
		btn.getKeyboard().setVisible(selected);
		switcher.setSelected(btn, selected);
	}

	@Override
	public void onClick(KeyBoardButtonBase btn, PointerEventType type) {
		if (processField == null) {
			return;
		}
		if (btn instanceof KeyBoardButtonFunctionalBase
				&& ((KeyBoardButtonFunctionalBase) btn).getAction() != null) {
			KeyBoardButtonFunctionalBase button = (KeyBoardButtonFunctionalBase) btn;

			if (Accents.isAccent(btn.getFeedback())) {
				processAccent(btn.getFeedback());
			} else {
				process(button.getAction());
			}
		} else {
			String text = btn.getFeedback();

			// translate commands and functions as appropriate
			if ("Integral".equals(text) || "Derivative".equals(text)) {
				if (hasKeyboard.attachedToEqEditor()) {
					text = "Integral".equals(text) ? String.valueOf(Unicode.INTEGRAL)
							: "d/dx";
				} else {
					text = hasKeyboard.getLocalization().getCommand(text);
				}
			} else
			// matches sin, cos, tan, asin, acos, atan
			if ((text.length() == 3 || text.length() == 4)
					&& "asin acos atan".contains(text)) {
				text = hasKeyboard.getLocalization().getFunction(text);
			}

			processField.insertString(text);
			processAccent(null);
			disableCapsLock();

			processField.setFocus(true);
		}
		if (Action.SWITCH_TO_123.name().equals(btn.getSecondaryAction())) {
			switcher.select(KeyboardType.NUMBERS);
		}
	}

	private void process(Action action) {
		switch (action) {
		case CAPS_LOCK:
			processShift();
			break;
		case BACKSPACE_DELETE:
		case LEFT_CURSOR:
		case RIGHT_CURSOR:
		case UP_CURSOR:
		case DOWN_CURSOR:
			startRepeater(action);
			break;
		case RETURN_ENTER:
			// make sure enter is processed correctly
			processField.onEnter();
			if (processField.resetAfterEnter()) {
				getUpdateKeyBoardListener().keyBoardNeeded(false, null);
			}
			break;
		case SWITCH_TO_SPECIAL_SYMBOLS:
			switcher.select(KeyboardType.SPECIAL);
			break;
		case SWITCH_TO_GREEK_CHARACTERS:
			switcher.select(KeyboardType.GREEK);
			break;
		case SWITCH_TO_ABC:
			switcher.select(getSwitchToAbcSource());
			break;
		case ANS:
			processField.ansPressed();
		}
	}

	private KeyboardType getSwitchToAbcSource() {
		if (locale.isLatinKeyboard()) {
			return KeyboardType.ABC;
		} else {
			return KeyboardType.LATIN;
		}
	}

	private void startRepeater(Action action) {
		repeater = new ButtonRepeater(action, this);
		repeater.start();
	}

	/**
	 * Execute action immediately without repeating
	 * 
	 * @param action
	 *            key action
	 */
	public void executeOnce(Action action) {
		switch (action) {
		case BACKSPACE_DELETE:
			processField.onBackSpace();
			break;
		case LEFT_CURSOR:
			processField.onArrow(KeyboardListener.ArrowType.left);
			break;
		case RIGHT_CURSOR:
			processField.onArrow(KeyboardListener.ArrowType.right);
			break;
		case UP_CURSOR:
			processField.onArrow(KeyboardListener.ArrowType.up);
			break;
		case DOWN_CURSOR:
			processField.onArrow(KeyboardListener.ArrowType.down);
			break;
		}
	}

	/**
	 * Handle ANS key
	 */
	protected void ansPressed() {
		// platform dependent
	}

	/**
	 * Make the keyboard visible.
	 */
	public void show() {
		setVisible(true);
	}

	@Override
	public void buttonPressEnded() {
		if (repeater != null) {
			repeater.cancel();
		}
	}

	/**
	 * show 3dot button on keyboard
	 */
	public void showMoreButton() {
		switcher.showMoreButton();
	}

	/**
	 * hide 3dot button on keyboard
	 */
	public void hideMoreButton() {
		switcher.hideMoreButton();
	}
}

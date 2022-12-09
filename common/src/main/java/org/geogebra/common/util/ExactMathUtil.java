package org.geogebra.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.apache.commons.math3.exception.MathRuntimeException;
import org.apache.commons.math3.linear.AnyMatrix;

/*
 * utilities for "exact" arithmetics
 * of arbitrary precision
 * 
 */
public class ExactMathUtil {

	/**
	 * BigDecimal wrapper with support for fixed scale
	 */
	public static class FixedScaleDecimal {

		private final int fixedScale;
		private static final int roundingMode = BigDecimal.ROUND_HALF_EVEN;

		private final BigDecimal impl;

		/**
		 * @param significance
		 *            significance
		 */
		public FixedScaleDecimal(int significance) {
			impl = BigDecimal.ZERO.setScale(significance);
			fixedScale = significance;
		}

		/**
		 * @param significance
		 *            significance
		 * @param val
		 *            value
		 */
		public FixedScaleDecimal(int significance, double val) {
			// super(val);
			// super.setScale(significance, roundingMode);
			impl = (new BigDecimal(val)).setScale(significance, roundingMode);
			fixedScale = significance;
		}

		/**
		 * @param md
		 *            decimal
		 */
		public FixedScaleDecimal(FixedScaleDecimal md) {
			impl = new BigDecimal(md.unscaledValue(), md.scale());
			fixedScale = md.scale();
		}

		@Override
		public String toString() {
			return impl.toString();
		}

		private int scale() {
			return impl.scale();
		}

		private BigInteger unscaledValue() {
			return impl.unscaledValue();
		}

		/**
		 * @param bd
		 *            decimal
		 */
		public FixedScaleDecimal(BigDecimal bd) {
			impl = new BigDecimal(bd.unscaledValue(), bd.scale());
			fixedScale = bd.scale();
		}

		/**
		 * @param significance
		 *            significance
		 * @param bd
		 *            value
		 */
		public FixedScaleDecimal(int significance, BigDecimal bd) {
			impl = new BigDecimal(bd.unscaledValue(), bd.scale())
					.setScale(significance, roundingMode);
			fixedScale = significance;
		}

		public int getScale() {
			return fixedScale;
		}

		public FixedScaleDecimal copy() {
			return new FixedScaleDecimal(this.getScale(), impl);
		}

		public FixedScaleDecimal negate() {
			return new FixedScaleDecimal(this.getScale(), impl.negate());
		}

		public FixedScaleDecimal add(FixedScaleDecimal md) {
			return new FixedScaleDecimal(this.getScale(), impl.add(md.getImpl()));
		}

		public BigDecimal getImpl() {
			return impl;
		}

		/**
		 * @param md
		 *            factor
		 * @return this * md
		 */
		public FixedScaleDecimal multiply(FixedScaleDecimal md) {
			return new FixedScaleDecimal(this.getScale(), impl.multiply(md.getImpl()));
		}

		/**
		 * @param md
		 *            subtrahend
		 * @return this - md
		 */
		public FixedScaleDecimal subtract(FixedScaleDecimal md) {
			return new FixedScaleDecimal(this.getScale(), impl.subtract(md.getImpl()));
		}

		/**
		 * @param md
		 *            divisor
		 * @return this / md
		 */
		public FixedScaleDecimal divide(FixedScaleDecimal md) {
			return new FixedScaleDecimal(this.getScale(), impl.divide(md.getImpl(),
					this.getScale(), BigDecimal.ROUND_HALF_EVEN));
		}

		/**
		 * @return square root of this
		 */
		public FixedScaleDecimal sqrt() {

			if (impl.compareTo(BigDecimal.ZERO) == 0) {
				return new FixedScaleDecimal(BigDecimal.ZERO);
			}

			FixedScaleDecimal TWO = new FixedScaleDecimal(BigDecimal.ONE.add(BigDecimal.ONE));
			double lower_bound = Math.sqrt(impl.doubleValue());

			int thisScale = this.getScale();
			int thisScalePlusOne = thisScale + 1;

			FixedScaleDecimal ret = new FixedScaleDecimal(thisScalePlusOne, lower_bound);
			FixedScaleDecimal radicand = new FixedScaleDecimal(thisScalePlusOne, impl);

			int iterCount = 0;
			while (ret.multiply(ret).subtract(radicand).divide(radicand)
					.divide(new FixedScaleDecimal(thisScalePlusOne, lower_bound * 2))
					.abs().doubleValue() > Math.pow(10, -thisScale)
					&& iterCount < 5) {
				ret = ret.add(radicand.divide(ret)).divide(TWO);
				iterCount++;
			}

			return new FixedScaleDecimal(thisScale, ret.getImpl());
		}

		public BigDecimal abs() {
			return impl.abs();
		}

		public double doubleValue() {
			return impl.doubleValue();
		}

		public int intValue() {
			return impl.intValue();
		}

		public int signum() {
			return impl.signum();
		}
	}

	public static class DecimalMatrix implements AnyMatrix {

		private int fixedScale;
		private int rowD;
		private int colD;

		private FixedScaleDecimal[][] data;

		/**
		 * @param significance
		 *            significance
		 * @param rowD
		 *            number of rows
		 * @param colD
		 *            number of columns
		 */
		public DecimalMatrix(int significance, int rowD, int colD) {
			fixedScale = significance;
			this.rowD = rowD;
			this.colD = colD;
			data = new FixedScaleDecimal[rowD][colD];
		}

		@Override
		public boolean isSquare() {
			return rowD == colD;
		}

		@Override
		public int getRowDimension() {
			return rowD;
		}

		@Override
		public int getColumnDimension() {
			return colD;
		}

		public int getScale() {
			return this.fixedScale;
		}

		public FixedScaleDecimal getEntry(int i, int j) {
			return data[i][j].copy();
		}

		public void setEntry(int i, int j, FixedScaleDecimal md) {
			data[i][j] = new FixedScaleDecimal(fixedScale, md.getImpl());
		}

		/**
		 * @return copy of the matrix
		 */
		public DecimalMatrix copy() {

			DecimalMatrix mdm = new DecimalMatrix(fixedScale, rowD, colD);

			for (int i = 0; i < rowD; i++) {
				for (int j = 0; j < colD; j++) {
					mdm.setEntry(i, j, data[i][j]);
				}
			}

			return mdm;
		}

		/**
		 * @param j
		 *            column
		 * @return numbers in given column
		 */
		public FixedScaleDecimal[] getColumn(int j) {
			FixedScaleDecimal[] ret = new FixedScaleDecimal[this.getRowDimension()];
			for (int i = 0; i < this.getRowDimension(); i++) {
				ret[i] = this.getEntry(i, j);
			}
			return ret;
		}

		/**
		 * @param j
		 *            column
		 * @param column
		 *            numbers for given column
		 */
		public void setColumn(int j, FixedScaleDecimal[] column) {
			for (int i = 0; i < this.getRowDimension(); i++) {
				this.setEntry(i, j, column[i]);
			}
		}

		/**
		 * @param i
		 *            row
		 * @return numbers in given row
		 */
		public FixedScaleDecimal[] getRow(int i) {
			FixedScaleDecimal[] ret = new FixedScaleDecimal[this.getColumnDimension()];
			for (int j = 0; j < this.getColumnDimension(); j++) {
				ret[j] = this.getEntry(i, j);
			}
			return ret;
		}

		/**
		 * @param i
		 *            row
		 * @param row
		 *            numbers for given row
		 */
		public void setRow(int i, FixedScaleDecimal[] row) {
			for (int j = 0; j < this.getColumnDimension(); j++) {
				this.setEntry(i, j, row[j]);
			}
		}

		/**
		 * @param matrix
		 *            matrix
		 * @param m
		 *            number of rows
		 * @param n
		 *            number of columns
		 * @return frobenius norm
		 */
		public FixedScaleDecimal frobNormSq(DecimalMatrix matrix, int m, int n) {
			FixedScaleDecimal ret = new FixedScaleDecimal(BigDecimal.ZERO);

			if (m == 0 || n == 0) {
				return ret;
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					ret = ret.add(matrix.getEntry(i, j)
							.multiply(matrix.getEntry(i, j)));
				}
			}

			return ret;
		}

		/**
		 * @param m
		 *            matrix
		 * @return product of matrices
		 */
		public DecimalMatrix multiply(DecimalMatrix m) {

			if (this.getColumnDimension() != m.getRowDimension()) {
				throw MathRuntimeException.createIllegalArgumentException(
						"Cannot multiply " + getRowDimension() + " x "
								+ getColumnDimension() + " and "
								+ m.getRowDimension() + " x "
								+ m.getColumnDimension() + "matrices!");

			}

			DecimalMatrix ret = new DecimalMatrix(this.getScale(),
					this.getRowDimension(), m.getColumnDimension());
			for (int i = 0; i < this.getRowDimension(); i++) {
				for (int j = 0; j < m.getColumnDimension(); j++) {
					FixedScaleDecimal entry = new FixedScaleDecimal(this.fixedScale, 0);
					for (int k = 0; k < this.getColumnDimension(); k++) {
						entry = entry.add(
								this.getEntry(i, k).multiply(m.getEntry(k, j)));
					}
					ret.setEntry(i, j, entry);
				}
			}
			return ret;
		}
	}
}

/**
 * Project: a00973641_lab07
 * File: MetaDataBean.java
 * Date: Jun 13, 2016
 * Time: 12:24:47 AM
 */
package a00973641.data;

import java.io.Serializable;

/**
 * @author Mara
 *
 */
public class MetaDataBean implements Serializable {

	/**
	 * Project: a00973641_lab07 File: MetaDataBean.java Date: Jun 13, 2016 Time:
	 * 12:27:15 AM
	 */
	private static final long serialVersionUID = 1L;
	private String columnName;
	private String dataType;
	private int columnWidth;
	private boolean searchable;
	private boolean writeable;
	private int nullable;

	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * @param columnName
	 *            the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 *            the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * @return the columnWidth
	 */
	public int getColumnWidth() {
		return columnWidth;
	}

	/**
	 * @param columnWidth
	 *            the columnWidth to set
	 */
	public void setColumnWidth(int columnWidth) {
		this.columnWidth = columnWidth;
	}

	/**
	 * @return the searchable
	 */
	public boolean isSearchable() {
		return searchable;
	}

	/**
	 * @param searchable
	 *            the searchable to set
	 */
	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	/**
	 * @return the writeable
	 */
	public boolean isWriteable() {
		return writeable;
	}

	/**
	 * @param writeable
	 *            the writeable to set
	 */
	public void setWriteable(boolean writeable) {
		this.writeable = writeable;
	}

	/**
	 * @return the nullable
	 */
	public int isNullable() {
		return nullable;
	}

	/**
	 * @param nullable
	 *            the nullable to set
	 */
	public void setNullable(int nullable) {
		this.nullable = nullable;
	}

}

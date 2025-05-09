package tw.shawn.apis;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GiftTable extends JTable{
	// 宣告 GiftModel 物件，用於作為 JTable 的資料模型
	private GiftModel model;
	// 宣告 GiftDB 物件，用於與資料庫進行互動
	private GiftDB db;

	// GiftTable 類的建構子
	public GiftTable() {

		try {
			// 創建 GiftDB 物件，用於處理資料庫相關操作
			db = new GiftDB();
		} catch (Exception e) {
			// 如果創建 GiftDB 物件時發生異常，則印出錯誤訊息
			System.out.println(e);
		}

		// 創建 GiftModel 物件，作為 JTable 的資料模型
		model = new GiftModel();
		// 將 GiftModel 設定為 JTable 的資料模型
		setModel(model);
		// 設定 JTable 的欄位標題，從 GiftDB 中取得欄位名稱
		model.setColumnIdentifiers(db.getColNames());
	}

	// 公有方法，用於刪除選定的資料列
	public void delRow() {
		// 取得使用者選取的資料列索引
		int del = getSelectedRow();
		// 檢查是否有選取任何資料列 (getSelectedRow() 返回 -1 表示沒有選取)
		if (del != -1) {
			// 調用 GiftDB 的 delData 方法，從資料庫中刪除指定索引的資料列
			db.delData(del);
			// 重新繪製 JTable，以更新顯示的資料
			repaint();
		}
	}

	// 私有內部類別 GiftModel，繼承自 DefaultTableModel，用於自定義 JTable 的資料模型
	private class GiftModel extends DefaultTableModel {

		// 覆寫 getRowCount 方法，返回資料的總行數，從 GiftDB 中取得
		@Override
		public int getRowCount() {
			return db.getRows();
		}

		// 覆寫 getColumnCount 方法，返回資料的總欄數，從 GiftDB 中取得
		@Override
		public int getColumnCount() {
			return db.getCols();
		}

		// 覆寫 getValueAt 方法，返回指定行列的資料，從 GiftDB 中取得
		@Override
		public Object getValueAt(int row, int column) {
			return db.getData(row, column);
		}

		// 覆寫 setValueAt 方法，用於設定指定行列的資料，並更新到 GiftDB
		@Override
		public void setValueAt(Object aValue, int row, int column) {
			// 將傳入的值強制轉換為 String，並調用 GiftDB 的 updateData 方法更新資料庫
			db.updateData((String)aValue, row, column);
		}

		// 覆寫 isCellEditable 方法，判斷指定儲存格是否可編輯
		@Override
		public boolean isCellEditable(int row, int column) {
			// 除了第一欄 (通常是 ID 或編號) 之外，其他欄位都可編輯
			return column != 0;
		}

	}

}
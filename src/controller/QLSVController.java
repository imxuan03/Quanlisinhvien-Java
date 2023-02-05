package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonModel;
import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements ActionListener{
	QLSVView view ;
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		JOptionPane.showConfirmDialog(view, "ban vua an"+src );
		
		if(src.equals("Them")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Them");
		}else if(src.equals("Luu")) {
			
			try {
				int maThiSinh = Integer.valueOf(this.view.textField_ID.getText());
				String tenThiSinh = this.view.textField_Hoten.getText();
				int queQuan = this.view.comboBox_Que_Quan_1.getSelectedIndex()-1;
				
				Tinh tinh = Tinh.getTinhById(queQuan);
				
				Date ngaySinh = new Date(this.view.textField_Ngay_Sinh.getText());
				
				boolean gioiTinh = true;
				if(this.view.radioButton_Nam.isSelected()) {
					gioiTinh = true;
				}else if(this.view.radioButton_Nu.isSelected()) {
					gioiTinh = false;
				}
				float diem1 = Float.valueOf(this.view.textField_Mon1.getText());
				float diem2 = Float.valueOf(this.view.textField_Mon2.getText());
				float diem3 = Float.valueOf(this.view.textField_Mon3.getText());
				
				
				ThiSinh thiSinh = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diem1, diem2, diem3);
				
				
				this.view.themHoacCapNhatThiSinh(thiSinh);
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}else if(src.equals("Cap Nhat")) {
			this.view.hienThiThongTinDaChon();
		}else if(src.equals("Xoa")) {
			this.view.thucHienXoa();
			this.view.xoaForm();
		}else if(src.equals("Huy Bo")) {
			this.view.xoaForm();
		}else if(src.equals("Tim Kiem")) {
			this.view.thucHienTimKiem();
		}else if(src.equals("Huy")) {
			this.view.thucHienHuyTimKiem();
		}
	}
	
}

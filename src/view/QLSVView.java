package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;
import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JRadioButton;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaSV;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_Hoten;
	public JTextField textField_Ngay_Sinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup group_Gioi_Tinh;
	public JComboBox comboBox_Que_Quan;
	public JLabel gioitinh;
	public JRadioButton radioButton_Nam;
	public JRadioButton radioButton_Nu;
	public JComboBox comboBox_Que_Quan_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 886, 605);
		
		ActionListener action = new QLSVController(this);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuFile.setBackground(Color.WHITE);
		menuFile.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.setBackground(Color.WHITE);
		menuFile.add(menuOpen);
		
		JMenuItem menuClose = new JMenuItem("Close");
		menuClose.setBackground(Color.WHITE);
		menuFile.add(menuClose);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.WHITE);
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.setBackground(Color.WHITE);
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuAbout.setBackground(Color.WHITE);
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About me");
		menuAboutMe.setBackground(Color.WHITE);
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_Que_Quan = new JLabel("Que Quan");
		label_Que_Quan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_Que_Quan.setBounds(36, 11, 79, 31);
		contentPane.add(label_Que_Quan);
		
		JLabel lable_MaSV = new JLabel("Ma SV");
		lable_MaSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV.setBounds(489, 11, 79, 31);
		contentPane.add(lable_MaSV);
		
		textField_MaSV = new JTextField();
		textField_MaSV.setBounds(542, 18, 154, 20);
		contentPane.add(textField_MaSV);
		textField_MaSV.setColumns(10);
		
		JButton button_Tim_Kiem = new JButton("Tim Kiem");
		button_Tim_Kiem.addActionListener(action);
		button_Tim_Kiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_Tim_Kiem.setBounds(706, 15, 100, 23);
		contentPane.add(button_Tim_Kiem);
		
		comboBox_Que_Quan = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getdsTinh();
		comboBox_Que_Quan.addItem("");
		for(Tinh tinh: listTinh) {
			comboBox_Que_Quan.addItem(tinh.getTenTinh());
		}
		
		comboBox_Que_Quan.setBounds(125, 17, 115, 22);
		contentPane.add(comboBox_Que_Quan);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 49, 851, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Danh Sach SV");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(20, 53, 129, 20);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Ma sv", "Ho Ten", "Que Quan","Ngay Sinh", "Gioi Tinh", "Diem1", "Diem2", "Diem3"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 84, 851, 237);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(10, 332, 851, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblThongTinhSinh = new JLabel("Thong Tinh Sinh Vien");
		lblThongTinhSinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThongTinhSinh.setBounds(10, 332, 203, 20);
		contentPane.add(lblThongTinhSinh);
		
		JLabel lable_MaSV_1 = new JLabel("Ma SV");
		lable_MaSV_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV_1.setBounds(10, 356, 79, 31);
		contentPane.add(lable_MaSV_1);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(63, 363, 154, 20);
		contentPane.add(textField_ID);
		
		JLabel lable_MaSV_2 = new JLabel("Ho ten");
		lable_MaSV_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV_2.setBounds(10, 388, 79, 31);
		contentPane.add(lable_MaSV_2);
		
		textField_Hoten = new JTextField();
		textField_Hoten.setColumns(10);
		textField_Hoten.setBounds(63, 395, 154, 20);
		contentPane.add(textField_Hoten);
		
		JLabel lable_MaSV_2_1 = new JLabel("Que Quan");
		lable_MaSV_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV_2_1.setBounds(10, 414, 79, 31);
		contentPane.add(lable_MaSV_2_1);
		
		comboBox_Que_Quan_1 = new JComboBox();
		comboBox_Que_Quan_1.addItem("");
		for(Tinh tinh : listTinh) {
			comboBox_Que_Quan_1.addItem(tinh.getTenTinh());
		}
		comboBox_Que_Quan_1.setBounds(102, 420, 115, 22);
		contentPane.add(comboBox_Que_Quan_1);
		
		JLabel lable_MaSV_1_1 = new JLabel("Ngay Sinh");
		lable_MaSV_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV_1_1.setBounds(10, 447, 79, 31);
		contentPane.add(lable_MaSV_1_1);
		
		textField_Ngay_Sinh = new JTextField();
		textField_Ngay_Sinh.setColumns(10);
		textField_Ngay_Sinh.setBounds(79, 454, 138, 20);
		contentPane.add(textField_Ngay_Sinh);
		
		gioitinh = new JLabel("Gioi Tinh");
		gioitinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gioitinh.setBounds(383, 366, 79, 31);
		contentPane.add(gioitinh);
		
		radioButton_Nam = new JRadioButton("Nam");
		radioButton_Nam.setBounds(476, 372, 111, 23);
		contentPane.add(radioButton_Nam);
		
		radioButton_Nu = new JRadioButton("Nu");
		radioButton_Nu.setBounds(620, 372, 111, 23);
		contentPane.add(radioButton_Nu);
		
		group_Gioi_Tinh = new ButtonGroup();
		group_Gioi_Tinh.add(radioButton_Nam);
		group_Gioi_Tinh.add(radioButton_Nu);
		
		
		JLabel lable_MaSV_2_2 = new JLabel("Mon 1");
		lable_MaSV_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV_2_2.setBounds(383, 398, 79, 31);
		contentPane.add(lable_MaSV_2_2);
		
		textField_Mon1 = new JTextField();
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(436, 405, 154, 20);
		contentPane.add(textField_Mon1);
		
		JLabel lable_MaSV_2_2_1 = new JLabel("Mon 2");
		lable_MaSV_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV_2_2_1.setBounds(383, 420, 79, 31);
		contentPane.add(lable_MaSV_2_2_1);
		
		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(436, 427, 154, 20);
		contentPane.add(textField_Mon2);
		
		JLabel lable_MaSV_2_2_2 = new JLabel("Mon 3");
		lable_MaSV_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lable_MaSV_2_2_2.setBounds(383, 447, 79, 31);
		contentPane.add(lable_MaSV_2_2_2);
		
		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(436, 454, 154, 20);
		contentPane.add(textField_Mon3);
		
		JButton Button_Them = new JButton("Them");
		Button_Them.addActionListener(action);
		Button_Them.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_Them.setBounds(26, 489, 89, 23);
		contentPane.add(Button_Them);
		
		JButton Button_Xoa = new JButton("Xoa");
		Button_Xoa.addActionListener(action);
		Button_Xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_Xoa.setBounds(189, 489, 89, 23);
		contentPane.add(Button_Xoa);
		
		JButton Button_Cap_Nhat = new JButton("Cap Nhat");
		Button_Cap_Nhat.addActionListener(action);
		Button_Cap_Nhat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_Cap_Nhat.setBounds(354, 489, 120, 23);
		contentPane.add(Button_Cap_Nhat);
		
		JButton Button_Luu = new JButton("Luu");
		Button_Luu.addActionListener(action);
		Button_Luu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_Luu.setBounds(542, 489, 89, 23);
		contentPane.add(Button_Luu);
		
		JButton Button_Huy_Bo = new JButton("Huy Bo");
		Button_Huy_Bo.addActionListener(action);
		Button_Huy_Bo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Button_Huy_Bo.setBounds(695, 489, 111, 23);
		contentPane.add(Button_Huy_Bo);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 476, 851, 2);
		contentPane.add(separator_1_2);
		
		JButton button_Huy_Tim_Kiem = new JButton("Huy");
		button_Huy_Tim_Kiem.addActionListener(action);
		button_Huy_Tim_Kiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button_Huy_Tim_Kiem.setBounds(793, 15, 69, 23);
		contentPane.add(button_Huy_Tim_Kiem);
		this.setVisible(true);
	}

	public void xoaForm() {
		// TODO Auto-generated method stub
		textField_ID.setText("");
		textField_Hoten.setText("");
		textField_MaSV.setText("");
		textField_Ngay_Sinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_Que_Quan.setSelectedIndex(-1);
		group_Gioi_Tinh.clearSelection();
	}

	public void themHoacCapNhatThiSinh(ThiSinh thiSinh) {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel)table.getModel();	
		if(!this.model.kiemTraTonTai(thiSinh)) {
			this.model.insert(thiSinh);
			model_table.addRow(new Object[] {thiSinh.getMaThiSinh()+"",
						thiSinh.getTenThiSinh()+"",
						thiSinh.getQueQuan().getTenTinh(),
						thiSinh.getNgaySinh().getDate()+"/"+(thiSinh.getNgaySinh().getMonth()+1)+"/"+(thiSinh.getNgaySinh().getYear()+1900),
						
						(thiSinh.isGioiTinh())?"Nam":"Nu",
						
						thiSinh.getDiemMon1()+"",
						thiSinh.getDiemMon2()+"",
						thiSinh.getDiemMon3()+""
					});
		}else {
			//cap nhap
			this.model.upDate(thiSinh);
			int soLuongDong = model_table.getRowCount();
			for(int i =0;i<soLuongDong;i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(thiSinh.getMaThiSinh()+"")) {
					model_table.setValueAt(thiSinh.getMaThiSinh()+"", i, 0);
					model_table.setValueAt(thiSinh.getTenThiSinh()+"", i, 1);
					model_table.setValueAt(thiSinh.getQueQuan().getTenTinh()+"", i, 2);
					
					model_table.setValueAt(thiSinh.getNgaySinh().getDate()+"/"+(thiSinh.getNgaySinh().getMonth()+1)+"/"+(thiSinh.getNgaySinh().getYear()+1900)+"", i, 3);
					
					model_table.setValueAt((thiSinh.isGioiTinh())?"Nam":"Nu"+"", i, 4);
					model_table.setValueAt(thiSinh.getDiemMon1()+"", i, 5);
					model_table.setValueAt(thiSinh.getDiemMon2()+"", i, 6);
					model_table.setValueAt(thiSinh.getDiemMon3()+"", i, 7);
				}
				
			}
		}
		
		
	}


	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel)table.getModel();
		int i_Row = table.getSelectedRow();
		
		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_Row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_Row, 1)+"";
		
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_Row, 2)+"");

		String s_ngaySinh = model_table.getValueAt(i_Row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);
		
		String textGioiTinh = model_table.getValueAt(i_Row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		
		float diem1 = Float.valueOf(model_table.getValueAt(i_Row, 5)+"");
		float diem2 = Float.valueOf(model_table.getValueAt(i_Row, 6)+"");
		float diem3 = Float.valueOf(model_table.getValueAt(i_Row, 7)+"");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diem1, diem2, diem3);
		return ts;
	}
	
	public void hienThiThongTinDaChon() {
		// TODO Auto-generated method stub
		ThiSinh thiSinh = getThiSinhDangChon();
		
		this.textField_ID.setText(thiSinh.getMaThiSinh()+"");
		this.textField_Hoten.setText(thiSinh.getTenThiSinh()+"");
		this.comboBox_Que_Quan_1.setSelectedItem(thiSinh.getQueQuan().getTenTinh());
		
		String s_ngaySinh = thiSinh.getNgaySinh().getDate()+"/"+(thiSinh.getNgaySinh().getMonth()+1)+"/"+(thiSinh.getNgaySinh().getYear()+1900);
		this.textField_Ngay_Sinh.setText(s_ngaySinh+"");
		//this.group_Gioi_Tinh.setSelected(null, gioiTinh);
		if(thiSinh.isGioiTinh()) {
			radioButton_Nam.setSelected(true);
		}else {
			radioButton_Nu.setSelected(true);
		}
		
		
		this.textField_Mon1.setText(thiSinh.getDiemMon1()+"");
		this.textField_Mon2.setText(thiSinh.getDiemMon1()+"");
		this.textField_Mon3.setText(thiSinh.getDiemMon1()+"");		
	}

	public void thucHienXoa() {
		// TODO Auto-generated method stub
		DefaultTableModel model_table = (DefaultTableModel)table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Ban co chac chan xoa?");
		if(luaChon == JOptionPane.YES_OPTION) {
			ThiSinh thiSinh = getThiSinhDangChon();
			this.model.delete(thiSinh);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienTimKiem() {
		//goi ham huy tim kiem
		this.thucHienHuyTimKiem();
		// TODO Auto-generated method stub
		int queQuan = this.comboBox_Que_Quan.getSelectedIndex()-1;
		
		String maThiSinh = this.textField_MaSV.getText();
		
		DefaultTableModel model_table = (DefaultTableModel)table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan>=0) {
			for(int i =0;i<soLuongDong;i++) {
				Tinh tinhDaChon = Tinh.getTinhById(queQuan);
				String tenTinh = model_table.getValueAt(i, 2)+"";
				String id = model_table.getValueAt(i, 0)+"";
				if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
				
			}
		}

		if(maThiSinh.length()>0) {
			for(int i =0;i<soLuongDong;i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.indexOf(maThiSinh)<0) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
				
			}
		}
		
		for(Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for(int i =0;i<soLuongDong;i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";
				if(idTrongTable.equals(idCanXoa.toString())) {
					try {
						model_table.removeRow(i); 
					} catch (Exception e) {
						// TODO: handle exception
					}
					break;
				}
				
			}
		}
	}
	public void themNhungThiSinhVaoTable(ThiSinh thiSinh) {
		DefaultTableModel model_table = (DefaultTableModel)table.getModel();
		model_table.addRow(new Object[] {thiSinh.getMaThiSinh()+"",
				thiSinh.getTenThiSinh()+"",
				thiSinh.getQueQuan().getTenTinh(),
				thiSinh.getNgaySinh().getDate()+"/"+(thiSinh.getNgaySinh().getMonth()+1)+"/"+(thiSinh.getNgaySinh().getYear()+1900),
				
				(thiSinh.isGioiTinh())?"Nam":"Nu",
				
				thiSinh.getDiemMon1()+"",
				thiSinh.getDiemMon2()+"",
				thiSinh.getDiemMon3()+""
			});
	}
	public void thucHienHuyTimKiem() {
		while(true) {
			DefaultTableModel model_table = (DefaultTableModel)table.getModel();
		int soLuongDong = model_table.getRowCount();
		
			if(soLuongDong == 0)
				break;
			else {
				try {
					model_table.removeRow(0);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		for(ThiSinh ts: this.model.getDsThiSinh()) {
			this.themNhungThiSinhVaoTable(ts);
		}
	}
}

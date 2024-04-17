package main.com;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import main.com.client.ui.ClientMain;
import main.com.config.Session;
import main.com.member.Login;
import main.com.product.ui.ProductApp;
import main.com.sales.SalesMain;
import main.com.store.ui.StoreMain;
import main.com.supplier.ui.SupplierMain;
import main.com.swing.ReleaseMain;

public class TogatherMain extends JFrame {

	private JPanel contentPane;
	private JPanel productPanel;
	private JPanel supplierMain;
	private JPanel storeMain;
	private JPanel releasePanel;
	private JPanel salesPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TogatherMain frame = new TogatherMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TogatherMain() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1280, 720);
		contentPane.add(tabbedPane);

		ProductApp productApp = new ProductApp();
		productPanel = productApp.getMainPanel();
		tabbedPane.addTab("제품", null, productPanel, null);

		supplierMain = new SupplierMain();
		tabbedPane.addTab("납품기업", null, supplierMain, null);

		storeMain = new ClientMain();
		tabbedPane.addTab("고객기업", null, storeMain, null);

		ReleaseMain releaseTest = new ReleaseMain();
		releasePanel = releaseTest.getReleasePanel();
		tabbedPane.addTab("출고관리", null, releasePanel, null);

		StoreMain storeMain = new StoreMain();
		JPanel storePanel = storeMain.getMainPane();
		tabbedPane.addTab("입고 관리",storePanel);

		SalesMain salesMain = new SalesMain();
		salesPanel = salesMain.getMainPanel();
		tabbedPane.addTab("매출 관리", null, salesPanel, null);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				int choice = JOptionPane.showConfirmDialog(
						TogatherMain.this,
						"프로그램을 종료하시겠습니까?",
						"종료",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE
				);
				if (choice == JOptionPane.YES_OPTION) {
					dispose();
					Session.cleanSession();
					Login login = new Login(); // 로그인 화면 객체 생성
					login.setVisible(true);
				}
			}
		});
	}
}

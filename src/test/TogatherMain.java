package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.com.client.ui.ClientMain;
import main.com.product.ui.ProductApp;
import main.com.supplier.ui.SupplierMain;
import main.com.swing.ReleaseTest;

import javax.swing.JTabbedPane;

public class TogatherMain extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public TogatherMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1280, 720);
		contentPane.add(tabbedPane);
		
		ProductApp productApp = new ProductApp();
		JPanel productPanel = productApp.getMainPanel();
		tabbedPane.addTab("제품", null, productPanel, null);
		
		ReleaseTest releaseTest = new ReleaseTest();
		JPanel releasePanel = releaseTest.getReleasePanel();
		tabbedPane.addTab("출고관리", null, releasePanel, null);
		
		JPanel supplierMain = new SupplierMain();
		tabbedPane.addTab("납품기업", null, supplierMain, null);
		
		JPanel storeMain = new ClientMain();
		tabbedPane.addTab("고객기업", null, storeMain, null);
		
	}
}

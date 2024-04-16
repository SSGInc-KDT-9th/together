package main.com.swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import main.com.config.AppConfig;
import main.com.config.Session;
import main.com.order.dao.OrderDAO;
import main.com.order.dto.OrderDTO;
import main.com.order.service.OrderService;
import main.com.order.service.OrderServiceImpl;
import main.com.release.dao.ReleaseDAO;
import main.com.release.dto.ReleaseDTO;
import main.com.release.service.ReleaseService;
import main.com.release.service.ReleaseServiceImpl;
import main.com.stock.domain.StockEdit;
import main.com.stock.repository.StockRepository;
import main.com.stock.service.StockService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class ReleaseTest extends JFrame {
   protected static final StockRepository Stock = null;
   private StockService stockService;
   JButton Enrollbtn;
   JButton Searchbtn;
   JButton Updatebtn;
   JButton Deletebtn;
   JButton Orderupdatebtn;
   
   private JPanel contentPane;
   String[] search = {"출고 번호", "출고 상태"};
   String[] search2 = {"선택", "대기중", "출고 완료"};
   private JTable table;
   private JScrollPane scrollPane;
   private JTable table_1;
   private JScrollPane scrollPane_1;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               ReleaseTest frame = new ReleaseTest();
               frame.setSize(1280, 720);
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public JPanel getReleasePanel() {
		return contentPane;
	}
   
   /**
    * Create the frame.
    */
   public ReleaseTest() {
      AppConfig appConfig = new AppConfig();
      stockService = appConfig.stockService();

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1278, 720);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      scrollPane = new JScrollPane();
      scrollPane.setBounds(36, 139, 509, 453);
      contentPane.add(scrollPane);
      
      table = new JTable();
      scrollPane.setViewportView(table);
      
      String [] header = {"출고번호","담당자ID","출고수량","출고일자","출고상태"};
      DefaultTableModel model = new DefaultTableModel(null, header);
        table.setModel(model);
        // 헤더의 DefaultTableCellRenderer 가져오기
        JTableHeader headerComponent = table.getTableHeader();
        TableCellRenderer headerRenderer = headerComponent.getDefaultRenderer();

        //헤더의 글자 크기를 변경
        TableCellRenderer customHeaderRenderer = (table1, value, isSelected, hasFocus, row, column) -> {
            JLabel label = (JLabel) headerRenderer.getTableCellRendererComponent(table1, value, isSelected, hasFocus, row, column);
            label.setFont(label.getFont().deriveFont(Font.BOLD, 16)); // 글자 크기 변경
            return label;
        };

        headerComponent.setDefaultRenderer(customHeaderRenderer);
      
      Searchbtn = new JButton("검색");
      Searchbtn.setBounds(435, 76, 109, 33);
      Searchbtn.setFont(new Font("고딕", Font.BOLD, 15));
      contentPane.add(Searchbtn);
      
      Enrollbtn = new JButton("주문 등록");
      Enrollbtn.setBounds(623, 102, 171, 55);
      Enrollbtn.setFont(new Font("고딕", Font.BOLD, 20));
      contentPane.add(Enrollbtn);
      
      Updatebtn = new JButton("출고상태 수정");
      Updatebtn.setBounds(394, 612, 151, 42);
      Updatebtn.setFont(new Font("고딕", Font.BOLD, 17));
      contentPane.add(Updatebtn);
      
      Deletebtn = new JButton("주문 삭제");
      Deletebtn.setBounds(1069, 102, 171, 55);
      Deletebtn.setFont(new Font("고딕", Font.BOLD, 20));
      contentPane.add(Deletebtn);
      
      
      scrollPane_1 = new JScrollPane();
      scrollPane_1.setBounds(643, 192, 568, 428);
      contentPane.add(scrollPane_1);
      
      table_1 = new JTable();
      scrollPane_1.setViewportView(table_1);
      
      String [] header1 = {"주문번호","상품ID","상품명","주문수량","기업명","주문일자"};
      DefaultTableModel model1 = new DefaultTableModel(null, header1);
        table_1.setModel(model1);
        
        JLabel lblNewLabel = new JLabel("출고 상태");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBounds(89, 74, 103, 35);
        lblNewLabel.setFont(new Font("고딕", Font.BOLD, 16));
        contentPane.add(lblNewLabel);
        
        JComboBox comboBox_1 = new JComboBox(search2);
        comboBox_1.setBounds(227, 76, 125, 33);
        Font font = new Font("고딕", Font.PLAIN, 15); 
        comboBox_1.setFont(font);
        contentPane.add(comboBox_1);
        
        Orderupdatebtn = new JButton("주문 수정");
        Orderupdatebtn.setBounds(859, 102, 160, 55);
        Orderupdatebtn.setFont(new Font("고딕", Font.BOLD, 20));
        contentPane.add(Orderupdatebtn);
      //주문 생성
      Enrollbtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              // 새로운 창을 생성하여 표시
              NewOrderFrame newOrderFrame = new NewOrderFrame();
              newOrderFrame.setVisible(true);
          }

         
      });
      
      //검색
      // 검색 버튼에 대한 ActionListener 설정
      Searchbtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              String selectedOption = (String) comboBox_1.getSelectedItem();
              
              
              String searchtext = selectedOption;
              ReleaseService service = new ReleaseServiceImpl();
              List<ReleaseDTO> list = service.statuselect(searchtext);
              System.out.println(list);
              DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setRowCount(0);
                    for (ReleaseDTO release : list) {
                       Object[] rowData = {
                                  release.getId(),
                                  release.getMember_id(),
                                  release.getItem_cnt(),
                                  release.getRelease_date(),
                                  release.getStatus()
                              };
//                              System.out.println(rowData[2]);
                              model.addRow(rowData);
                          }
                    if(searchtext=="선택") {
                      ReleaseService service2 = new ReleaseServiceImpl();
                      List<ReleaseDTO> list2 = service2.findall();
                      System.out.println(list2);
                      model.setRowCount(0);
                            for (ReleaseDTO release : list2) {
                               Object[] rowData = {
                                          release.getId(),
                                          release.getMember_id(),
                                          release.getItem_cnt(),
                                          release.getRelease_date(),
                                          release.getStatus()
                                      };
                                      model.addRow(rowData);
                                  }
                      }
                    
          }
          
          
            
      });
      
      // table에서 특정 행이 선택되었을 때 이벤트 처리
      table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
          @Override
          public void valueChanged(ListSelectionEvent e) {
              if (!e.getValueIsAdjusting()) {
                  int selectedRowIndex = table.getSelectedRow();
                  if (selectedRowIndex != -1) {
                      long releaseid = (long) table.getValueAt(selectedRowIndex, 0); // 선택된 행의 출고번호 가져오기
                      
                      // 주문 목록을 해당 출고번호로 조회하여 테이블에 표시
                      model1.setRowCount(0);
                      OrderService order = new OrderServiceImpl();
                      List<OrderDTO> list = order.orderselect(releaseid);
                      for (OrderDTO order1 : list) {
                          Object[] rowData = {
                              order1.getId(),
                              order1.getRelease_id(),
                              order1.getProduct_id(),
                              order1.getOrder_cnt(),
                              order1.getOrder_date(),
                              order1.getClient_id()
                          };
                          int pid = (int) rowData[2];
                          String pname = order.productselect(pid);
                          int cid = (int) rowData[5];
                          String cname = order.companyselect(cid);
                          Object[] result = {
                              rowData[0],
                              pid,
                              pname,
                              rowData[3],
                              cname,
                              rowData[4]
                          };
                          model1.addRow(result);
                      }
                  }
              }
          }
      });
      //삭제 버튼
      Deletebtn.addActionListener(new ActionListener() {
                     
      @Override
      public void actionPerformed(ActionEvent e) {

         // 주문 목록 삭제
         int selectedRowIndex1 = table_1.getSelectedRow();
         if (selectedRowIndex1 != -1 && model1 != null) {
             // 삭제 여부 확인 대화 상자 표시
             int option1 = JOptionPane.showConfirmDialog(null, "주문을 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
             if (option1 == JOptionPane.YES_OPTION) {
                 // 확인을 선택한 경우
                 int orderid = (int) table_1.getValueAt(selectedRowIndex1, 0); // 주문번호 가져오기
                 OrderService order = new OrderServiceImpl();
                 order.setDao(new OrderDAO());
                 int n3 = order.orderdelete(orderid);
               
                 model1.removeRow(selectedRowIndex1);
             }
             return;
         }

         // 출고 목록 삭제
         int selectedRowIndex2 = table.getSelectedRow();
         if (selectedRowIndex2 != -1 && model != null) {
             // 삭제 여부 확인 대화 상자 표시
             int option2 = JOptionPane.showConfirmDialog(null, "출고를 삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_OPTION);
             if (option2 == JOptionPane.YES_OPTION) {
                 //확인을 선택한 경우
                 long releaseid = (long) table.getValueAt(selectedRowIndex2, 0); // 출고번호 가져오기
                 ReleaseService rs = new ReleaseServiceImpl();
                 rs.setDao(new ReleaseDAO());
                 int n4 = rs.releasedelete(releaseid);
                 
                 model.removeRow(selectedRowIndex2);
             }
         }}
   });
         //수정(출고 상태 변경)
      Updatebtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
               // 현재 table에 있는 행 정보 가져오기
              if (table.getSelectedRow() == -1) {
                  JOptionPane.showMessageDialog(null, "변경할 출고 항목을 선택해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
              } else {
                 int option = JOptionPane.showConfirmDialog(null, "출고상태를 변경하시겠습니까?", "출고상태 변경 확인", JOptionPane.YES_NO_OPTION);
                 if (option == JOptionPane.YES_OPTION) {
                     DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
                     int rowCount = model1.getRowCount();
                     boolean allInventoryAvailable = true; // 모든 행의 재고량이 충분한지 여부를 나타내는 변수
                     List<StockEdit> stockEdits = new ArrayList<>(); // 업데이트할 재고 정보를 담는 리스트
                     for (int i = 0; i < rowCount; i++) {
                         Object[] rowData = new Object[model1.getColumnCount()];
                         for (int j = 0; j < model1.getColumnCount(); j++) {
                             rowData[j] = model1.getValueAt(i, j);
                         }
                         int productId = (int) rowData[1];
                         int itemcnt = (int) rowData[3];
                         ReleaseService rs = new ReleaseServiceImpl();
                         int cnt = rs.Inventoryselect(productId);
                         if (cnt >= itemcnt) { // 재고량이 충분한 경우
                             int modifyInventory = cnt - itemcnt; // 수정할 재고량 계산
                             StockEdit stockEdit = StockEdit.builder()
                                     .productId((long) productId)
                                     .inventory(modifyInventory)
                                     .build();
                             stockEdits.add(stockEdit); // 재고 정보를 리스트에 추가
                         } else {
                             allInventoryAvailable = false; // 재고량이 충분하지 않은 경우
                             break; // 변경 중단
                         }
                     }
                     
                     if (allInventoryAvailable) { // 모든 행의 재고량이 충분한 경우
                         for (StockEdit stockEdit : stockEdits) {
                             stockService.editRelease(stockEdit.getProductId(), stockEdit); // 재고 업데이트
                         }
                         JOptionPane.showMessageDialog(null, "출고 완료 되었습니다.", "알림", JOptionPane.WARNING_MESSAGE);
                         //출고 완료로 변경
                         //출고 일자 현재 날짜로 변경
                     
                         int selectedRowIndex = table.getSelectedRow();

                         if (selectedRowIndex != -1) {
                             // 선택된 행의 첫 번째 열 값 가져오기
                             long releaseid = (long) table.getValueAt(selectedRowIndex, 0);
                             ReleaseService rs = new ReleaseServiceImpl();
                             rs.updatestatus(releaseid);
                         } 
                         
                     } else { // 재고량이 충분하지 않은 경우
                         JOptionPane.showMessageDialog(null, "일부 상품의 재고가 부족합니다.", "재고 부족 경고", JOptionPane.WARNING_MESSAGE);
                     }
                 }
                      
                      
                  }
              }   
         
      });   
      //주문 수정
      Orderupdatebtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
               // 현재 table에 있는 행 정보 가져오기
              if (table_1.getSelectedRow() == -1) {
                  JOptionPane.showMessageDialog(null, "수정할 항목을 선택해주세요.", "알림", JOptionPane.WARNING_MESSAGE);
              } else {
                 int option = JOptionPane.showConfirmDialog(null, "주문을 수정하시겠습니까?", "주문 수정 확인", JOptionPane.YES_NO_OPTION);
                 if (option == JOptionPane.YES_OPTION) {
                	 
                	 String icecream = (String) table_1.getValueAt(table_1.getSelectedRow(), 2);
                    // 새로운 창을 생성하여 표시
                    updateorderFrame uo = new updateorderFrame(icecream);
                    uo.setVisible(true);
                    
                   
                 }
                      
                      
                  }
              }   
         
          

         
      });
}   
}
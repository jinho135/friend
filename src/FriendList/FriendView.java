package FriendList;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class FriendView extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lbName;
	private JLabel lbBirth;
	private JLabel lbPhone;
	private JLabel lbAddr;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddr;
	private JButton btnView;
	private JButton btnInsert;
	private JSplitPane splitPane_1;
	private JPanel panel_1;
	private JComboBox jcb;
	private JTextField searchtf;
	private JButton searchbtn;

	FriendDBAImpl dba = new FriendDBAImpl();
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JButton btnSelect;
	private JButton btnUpdate;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
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
	public FriendView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		contentPane.add(getSplitPane());
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(200);
		}
		return splitPane;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
					"\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(null);
			panel.add(getLbName());
			panel.add(getLbBirth());
			panel.add(getLbPhone());
			panel.add(getLbAddr());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddr());
			panel.add(getBtnView());
			panel.add(getBtnInsert());
			
		}
		return panel;
	}

	private JLabel getLbName() {
		if (lbName == null) {
			lbName = new JLabel("이름");
			lbName.setHorizontalAlignment(SwingConstants.RIGHT);
			lbName.setBounds(0, 22, 60, 25);
		}
		return lbName;
	}

	private JLabel getLbBirth() {
		if (lbBirth == null) {
			lbBirth = new JLabel("생일");
			lbBirth.setHorizontalAlignment(SwingConstants.RIGHT);
			lbBirth.setBounds(0, 52, 60, 25);
		}
		return lbBirth;
	}

	private JLabel getLbPhone() {
		if (lbPhone == null) {
			lbPhone = new JLabel("전화번호");
			lbPhone.setHorizontalAlignment(SwingConstants.RIGHT);
			lbPhone.setBounds(0, 82, 60, 25);
		}
		return lbPhone;
	}

	private JLabel getLbAddr() {
		if (lbAddr == null) {
			lbAddr = new JLabel("주소");
			lbAddr.setHorizontalAlignment(SwingConstants.RIGHT);
			lbAddr.setBounds(0, 112, 60, 25);
		}
		return lbAddr;
	}

	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(70, 22, 115, 25);
			tfName.setColumns(10);
		}
		return tfName;
	}

	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setColumns(10);
			tfBirth.setBounds(70, 52, 115, 25);
		}
		return tfBirth;
	}

	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(70, 82, 115, 25);
		}
		return tfPhone;
	}

	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(70, 112, 115, 25);
		}
		return tfAddr;
	}

	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("전체보기");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					ArrayList<Friend> arr = dba.friendView();
					for (Friend f : arr) {
						ta.append("번호 : " + f.getNum() + "\n");
						ta.append("이름 : " + f.getName() + "\n");
						ta.append("생일 : " + f.getBirth() + "\n");
						ta.append("전화 : " + f.getPhone() + "\n");
						ta.append("주소 : " + f.getAddr() + "\n");
						ta.append("\n");
					}
				}
			});
			btnView.setBounds(101, 180, 86, 23);
		}
		return btnView;
	}

	private JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton("추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Friend f = new Friend();
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddr.getText());
					dba.friendInsert(f);
				}
			});
			btnInsert.setBounds(12, 180, 84, 23);
		}
		return btnInsert;
	}

	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setDividerLocation(200);
		}
		return splitPane_1;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getJcb());
			panel_1.add(getSearchtf());
			panel_1.add(getSearchbtn());
		}
		return panel_1;
	}

	private JComboBox getJcb() {
		if (jcb == null) {
			jcb = new JComboBox();
			jcb.setModel(new DefaultComboBoxModel(new String[] { "이름", "생일", "전화", "주소" }));
			jcb.setToolTipText("");
			jcb.setBounds(0, 11, 62, 21);
		}
		return jcb;
	}

	private JTextField getSearchtf() {
		if (searchtf == null) {
			searchtf = new JTextField();
			searchtf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchbtn.doClick();
				}
			});
			searchtf.setBounds(63, 11, 86, 21);
			searchtf.setColumns(10);
		}
		return searchtf;
	}

	private JButton getSearchbtn() {
		if (searchbtn == null) {
			searchbtn = new JButton("검색");
			searchbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (searchtf.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "검색어를 입력하세요.");
						return;
					}
					ta.setText("");
					String key[] = { "name", "birth", "phone", "addr" };
					int idx = jcb.getSelectedIndex();
					ArrayList<Friend> arr = dba.friendSearch(searchtf.getText().trim(), key[idx]);
					for (int i = 0; i < arr.size(); i++) {
						ta.append("번호 : " + arr.get(i).getNum() + "\n");
						ta.append("이름 : " + arr.get(i).getName() + "\n");
						ta.append("생일 : " + arr.get(i).getBirth() + "\n");
						ta.append("전화 : " + arr.get(i).getPhone() + "\n");
						ta.append("주소 : " + arr.get(i).getAddr() + "\n");
						ta.append("\n");
					}
				}
			});
			searchbtn.setBounds(150, 10, 62, 23);
		}
		return searchbtn;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}

	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
			ta.setEditable(false);
			ta.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uC804\uCCB4\uBCF4\uAE30",

					TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return ta;
	}

}

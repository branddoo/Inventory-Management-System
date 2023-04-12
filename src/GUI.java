import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel ordPanel;
	private JPanel newPanel;
	private JPanel manPanel;
	private JLabel idLabel;
	private JTextField txtID;
	private JLabel idName;
	private JTextField txtWName;
	private JButton btnAddWarehouse;
	private JTextArea NewWareTXTarea;
	private JComboBox mPanelComboBox;
	private JLabel WarehouseSelect;
	private JButton btnPullWarehouse;
	private JTextArea ManageTextArea;
	private specWarehouse sWare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	
	LinkedList<specWarehouse> Warehouses = new LinkedList();
	private JLabel NewWName;
	private JTextField txtModWarehouseName;
	private JButton btnModWarehouseName;
	private JLabel SelectInv;
	private JComboBox ComboBoxItem;
	private JLabel ItemName;
	private JTextField txtItemName;
	private JLabel ItemDesc;
	private JTextField txtItemDesc;
	private JLabel itemPrice;
	private JTextField txtPrice;
	private JLabel itemQ;
	private JTextField txtQuantity;
	private JButton btnModItem;
	private JButton btnPullItem;
	private JButton btnNewItem;
	
	public GUI() {
		
		setTitle("Warehouse Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 524, 422);
		contentPane.add(tabbedPane);
		
		ordPanel = new JPanel();
		tabbedPane.addTab("Order", null, ordPanel, null);
		
		newPanel = new JPanel();
		tabbedPane.addTab("New Warehouse", null, newPanel, null);
		
		idLabel = new JLabel("Warehouse ID:");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newPanel.add(idLabel);
		
		txtID = new JTextField();
		newPanel.add(txtID);
		txtID.setColumns(10);
		
		idName = new JLabel("Warehouse Name:");
		idName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newPanel.add(idName);
		
		txtWName = new JTextField();
		newPanel.add(txtWName);
		txtWName.setColumns(10);
		
		btnAddWarehouse = new JButton("Add Warehouse");
		btnAddWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddWarehouseClicked();
			}
		});
		newPanel.add(btnAddWarehouse);
		
		NewWareTXTarea = new JTextArea();
		NewWareTXTarea.setTabSize(0);
		NewWareTXTarea.setRows(8);
		NewWareTXTarea.setColumns(40);
		newPanel.add(NewWareTXTarea);
		
		manPanel = new JPanel();
		tabbedPane.addTab("Manage Warehouse", null, manPanel, null);
		manPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		WarehouseSelect = new JLabel("Select Warehouse to Modify:");
		WarehouseSelect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(WarehouseSelect);
		
		//String[] itemsArray = items.toArray(new String[items.size()]);
		mPanelComboBox = new JComboBox();
		mPanelComboBox.setMinimumSize(new Dimension(55, 22));
		mPanelComboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(mPanelComboBox);
		
		btnPullWarehouse = new JButton("Pull Warehouse");
		btnPullWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				btnPullWarehouseClicked();
			}
		});
		btnPullWarehouse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(btnPullWarehouse);
		
		ManageTextArea = new JTextArea();
		ManageTextArea.setRows(8);
		ManageTextArea.setColumns(40);
		manPanel.add(ManageTextArea);
		
		NewWName = new JLabel("New Warehouse Name: ");
		NewWName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(NewWName);
		
		txtModWarehouseName = new JTextField();
		txtModWarehouseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(txtModWarehouseName);
		txtModWarehouseName.setColumns(10);
		
		btnModWarehouseName = new JButton("Mod Name");
		btnModWarehouseName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(btnModWarehouseName);
		
		SelectInv = new JLabel("Select Inventory Item to be modified, or click create a new item.");
		SelectInv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(SelectInv);
		
		ComboBoxItem = new JComboBox();
		manPanel.add(ComboBoxItem);
		
		btnPullItem = new JButton("Pull Item ");
		btnPullItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPullItemClicked();
			}
		});
		btnPullItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(btnPullItem);
		
		ItemName = new JLabel("Item Name: ");
		ItemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(ItemName);
		
		txtItemName = new JTextField();
		manPanel.add(txtItemName);
		txtItemName.setColumns(10);
		
		ItemDesc = new JLabel("Description: ");
		ItemDesc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(ItemDesc);
		
		txtItemDesc = new JTextField();
		manPanel.add(txtItemDesc);
		txtItemDesc.setColumns(10);
		
		itemPrice = new JLabel("Price(00.00):");
		itemPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(itemPrice);
		
		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
		            e.consume();
		        }
		    }
		});
		manPanel.add(txtPrice);
		txtPrice.setColumns(10);
		
		itemQ = new JLabel("Quantity(00):");
		itemQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(itemQ);
		
		txtQuantity = new JTextField();
		txtQuantity.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
		            e.consume();
		        }
		    }
		});
		manPanel.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		btnModItem = new JButton("Mod Item");
		btnModItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModItemClicked();
			}
		});
		btnModItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(btnModItem);
		
		btnNewItem = new JButton("Click to create new item");
		btnNewItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewItemClicked();
			}
		});
		btnNewItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manPanel.add(btnNewItem);
		for (specWarehouse warehouse : Warehouses) {
			mPanelComboBox.addItem(warehouse.getName());
		}
	}

	protected void btnModItemClicked() {
		// TODO Auto-generated method stub
		
	}

	protected void btnNewItemClicked() {
		System.out.println("check");
		String itemName = JOptionPane.showInputDialog(null, "Enter item name:");
		String itemDesc = JOptionPane.showInputDialog(null, "Enter item description:");
		String priceStr = JOptionPane.showInputDialog(null, "Enter item price:");
		double itemPrice = Double.parseDouble(priceStr);
		String quantityStr = JOptionPane.showInputDialog(null, "Enter item quantity:");
		int itemQuantity = Integer.parseInt(quantityStr);
		invItem newItem = new invItem(itemName, itemDesc, itemPrice, itemQuantity);
		sWare.inv.add(newItem);
		txtItemName.setText("");
		txtItemDesc.setText("");
		txtPrice.setText("");
		txtQuantity.setText("");
		for(invItem item : sWare.inv) {
			ManageTextArea.append("\t"+item.toString()+"\n");
				ComboBoxItem.addItem(item.getName());
		}
	}

	protected void btnPullItemClicked() {
		String selectedInvItem = (String) ComboBoxItem.getSelectedItem();
		String selectedItemName = (String) ComboBoxItem.getSelectedItem();
		invItem selectedItem = null;
		for (invItem item : sWare.inv) {
			if (item.getName().equals(selectedItemName)) {
				selectedItem = item;
				break;
			}
		}
		if (selectedItem != null) {
			txtItemName.setText(selectedItem.getName());
			txtItemDesc.setText(selectedItem.getDescription());
			txtPrice.setText(String.valueOf(selectedItem.getPrice()));
			txtQuantity.setText(String.valueOf(selectedItem.getQuantity()));
		}
	}	

	protected void btnPullWarehouseClicked(){
		String selectedWarehouseName = (String) mPanelComboBox.getSelectedItem();
		selectedWarehouseName = selectedWarehouseName.trim();
		for (specWarehouse warehouse : Warehouses) {
			System.out.println("Warehouse name: " + warehouse.getName());
			if (warehouse.getName().equals(selectedWarehouseName)) {
				System.out.println("Found warehouse: " + warehouse.getName());
				ManageTextArea.setText(warehouse.toString()+"\n");
				txtModWarehouseName.setText(warehouse.getName());
				sWare=warehouse;
				ComboBoxItem.removeAllItems();
				for(invItem item : sWare.inv) {
					ManageTextArea.append("\t"+item.toString()+"\n");
						ComboBoxItem.addItem(item.getName());
				}
				break;
			}
		}
	}

	protected void btnAddWarehouseClicked() {
		specWarehouse warehouse = new specWarehouse(txtID.getText(),txtWName.getText());
		Warehouses.add(warehouse);
		System.out.println("Added warehouse: " + warehouse.getName());
		NewWareTXTarea.append("Added Warehouse:"+warehouse.toString()+"\n");
		mPanelComboBox.removeAllItems();
		for(specWarehouse e:Warehouses) {
			mPanelComboBox.addItem(e.getName());
		}
	}
}

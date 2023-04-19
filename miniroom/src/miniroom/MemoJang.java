package miniroom;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

import javax.swing.*;

public class MemoJang extends JFrame implements ActionListener{
 JButton btnCopy = new JButton("����");
 JButton btnPaste = new JButton("�ٿ��ֱ�");
 JButton btnCut = new JButton("�߶󳻱�");
 JButton btnDel = new JButton("����");
 JTextArea txtMemo = new JTextArea("", 10, 40);
 String copyText;
 
 // �׷��Ƿ� �޴��������� ����ٰ�  �޴�
 JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
 JMenuItem mnuCopy, mnuPaste, mnuCut, mnuDel;
 JMenuItem mnuAbout, mnuEtc1, mnuEtc2;
 
 // �˾� �޴�
 JPopupMenu popup;
 JMenuItem m_white, m_blue, m_yellow;
 
 public MemoJang() {
  super("���̾");
  
  initLayout();
  menuLayout();
  setBounds(0, 0, 820, 820);
  setVisible(true);
//  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 
 private void initLayout() {
  JPanel panel = new JPanel();
  panel.add(btnCopy);
  panel.add(btnPaste);
  panel.add(btnCut);
  panel.add(btnDel);
  add("South", panel);
  add("Center", txtMemo);
  
  btnCopy.addActionListener(this);
  btnPaste.addActionListener(this);
  btnCut.addActionListener(this);
  btnDel.addActionListener(this);
 }
 
 private void menuLayout() {        // �޴��������� ���⼭ �����
  JMenuBar menuBar = new JMenuBar();
  
  JMenu mnuFile = new JMenu("����");     // �ָ޴�
  mnuNew = new JMenuItem("�� ����");     // �θ޴�
  mnuOpen  = new JMenuItem("����...");
  mnuSave = new JMenuItem("����...");
  mnuExit = new JMenuItem("����");
  mnuFile.add(mnuNew);
  mnuFile.add(mnuOpen);
  mnuFile.add(mnuSave);
  mnuFile.addSeparator();        // ���м�
  mnuFile.add(mnuExit);
  
  JMenu mnuEdit = new JMenu("����");     // �ָ޴�
  mnuCopy = new JMenuItem("����");
  mnuPaste = new JMenuItem("�ٿ��ֱ�");
  mnuCut = new JMenuItem("�߶󳻱�");
  mnuDel = new JMenuItem("����");
  mnuEdit.add(mnuCopy);
  mnuEdit.add(mnuPaste);
  mnuEdit.add(mnuCut);
  mnuEdit.add(mnuDel);
  
  JMenu mnuHelp = new JMenu("����");
  mnuAbout = new JMenuItem("���̾��...");
  mnuHelp.add(mnuAbout);
  JMenu mnuEtc = new JMenu("��Ÿ");   // �θ޴��� �θ޴�
   mnuEtc1 = new JMenuItem("����");
   mnuEtc2 = new JMenuItem("������");
   mnuEtc.add(mnuEtc1);
   mnuEtc.add(mnuEtc2);
  mnuHelp.add(mnuEtc);
  
  menuBar.add(mnuFile);
  menuBar.add(mnuEdit);
  menuBar.add(mnuHelp);
  
  setJMenuBar(menuBar);        // Frame�� �޴��� ����
  
  mnuNew.addActionListener(this);      // �޴��� ������ ����
  mnuSave.addActionListener(this);
  mnuOpen.addActionListener(this);
  mnuExit.addActionListener(this);
  mnuCopy.addActionListener(this);
  mnuPaste.addActionListener(this);
  mnuCut.addActionListener(this);
  mnuDel.addActionListener(this);
  mnuAbout.addActionListener(this);
  mnuEtc1.addActionListener(this);
  mnuEtc2.addActionListener(this);
  
  // �˾� �޴�(��Ŭ���� ����)
  popup = new JPopupMenu();
  JMenu m_col = new JMenu("���� ����");
  m_white = new JMenuItem("�Ͼ�");
  m_blue = new JMenuItem("�Ķ�");
  m_yellow = new JMenuItem("���");
  m_col.add(m_white);
  m_col.add(m_blue);
  m_col.add(m_yellow);
  m_white.addActionListener(this);
  m_blue.addActionListener(this);
  m_yellow.addActionListener(this);
  popup.add(m_col);   // �˾��� �ִ°�
  txtMemo.add(popup);   // �˾� �޴� �߰�
  
  txtMemo.addMouseListener(new MouseAdapter() {
   @Override
   public void mousePressed(MouseEvent e) {
    // ������ ��ư Ŭ�� �� ...
    if(e.getModifiers() == MouseEvent.BUTTON3_MASK) { // ������ 1 ����� 2 �������� 3   BUTTON3_MASK - ������ ��ư
     // System.out.println("����");
     popup.show(txtMemo, e.getX(), e.getY());
    }
   }
  });
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {   // �޴������� ������ ����
  //����
  if(e.getSource() == btnCopy || e.getSource() == mnuCopy) {
   // copyText = txtMemo.getText();  // ��ü�� �� ���簡 �ȴ�
   copyText = txtMemo.getSelectedText();
   // System.out.println(copyText);
  
  //�ٿ��ֱ�
  } else if(e.getSource() == btnPaste || e.getSource() == mnuPaste) {
   // txtMemo.setText(copyText);
   int position = txtMemo.getCaretPosition();  // ��ġ ���
   txtMemo.insert(copyText, position);    // append �߰� insert ����
  
  //�߶󳻱�
  } else if(e.getSource() == btnCut || e.getSource() == mnuCut) {
   copyText = txtMemo.getSelectedText();
   int start = txtMemo.getSelectionStart();
   int end = txtMemo.getSelectionEnd();
   txtMemo.replaceRange("", start, end);
  
  //�����
  } else if(e.getSource() == btnDel || e.getSource() == mnuDel) {
   int start = txtMemo.getSelectionStart();
   int end = txtMemo.getSelectionEnd();
   txtMemo.replaceRange("", start, end);   // �������� ġȯ�ϴ� �� replaceRange("", ������ġ, ����ġ)
  
  //������
  } else if(e.getSource() == mnuNew) {   
   txtMemo.setText("");
   setTitle("������� - �޸���");
  
  //����
  } else if(e.getSource() == mnuOpen) {    // ����
   FileDialog dialog = new FileDialog(this, "����", FileDialog.LOAD);
   dialog.setDirectory(".");   // .�� ��������
   dialog.setVisible(true);   // �ڽ��� �׳� Ʋ�̰�
   if(dialog.getFile() == null) return;
   String dfName = dialog.getDirectory() + dialog.getFile();  // ��θ� ���ϸ�
   
   try {
    BufferedReader reader = new BufferedReader(new FileReader(dfName));
    txtMemo.setText("");
    String line;
    while((line = reader.readLine()) != null) {     // �о�� ������ ���� ��������
     txtMemo.append(line + "\n");       // txtMemo�� �߰�
    }
    reader.close();
    
    setTitle(dialog.getFile() + " - �޸���" );
   } catch (Exception e2) {
    JOptionPane.showMessageDialog(this, "���� ����");
   }
   
  //����
  } else if(e.getSource() == mnuSave) {    
   // ���� �۾��� ���� ��θ� �� ���ϸ� ���
   FileDialog dialog = new FileDialog(this, "����", FileDialog.SAVE);
   dialog.setDirectory(".");   // .�� ��������
   dialog.setVisible(true);   // �ڽ��� �׳� Ʋ�̰�
   if(dialog.getFile() == null) return; // �̰ɻ��� ��Ҹ� �ص� �����̵�
   String dfName = dialog.getDirectory() + dialog.getFile();  // ��θ� ���ϸ�
   // System.out.println(dfName);
   // ���� ������ ���⿡��
   try {
    BufferedWriter writer = new BufferedWriter(new FileWriter(dfName));
    writer.write(txtMemo.getText());
    writer.close();
    
    setTitle(dialog.getFile() + " - �޸���" );
   } catch (Exception e2) {
    JOptionPane.showMessageDialog(this, "���� ����");
   }
   
  //����
  } else if(e.getSource() == mnuExit) {
   System.exit(0);
   
  //�޸����̶�..
  } else if(e.getSource() == mnuAbout) {
   new MemoAbout(this);
   // System.out.println("���� ���");
   
  //��Ÿ1 : ���⿭��
  } else if(e.getSource() == mnuEtc1) {
   try {    // �ܺο� �ִ� ������ �����ű� ������
    Runtime runtime = Runtime.getRuntime();
    runtime.exec("calc.exe");
   } catch (Exception e2) {
    // TODO: handle exception
   }
   
  //��Ÿ2 : ������ ����
  } else if(e.getSource() == mnuEtc2) {    // ��Ÿ2
   try {    // �ܺο� �ִ� ������ �����ű� ������
    Runtime.getRuntime().exec("freesell.exe");
   } catch (Exception e2) {
    // TODO: handle exception
   }
   
  //��Ŭ���ÿ� ��Ÿ���� �˾��޴��� ���� ����
  } else if(e.getSource() == m_white) {   // �˾��޴�
   txtMemo.setBackground(Color.WHITE);
  } else if(e.getSource() == m_blue) {   // �˾��޴�
   txtMemo.setBackground(Color.BLUE);
  } else if(e.getSource() == m_yellow) {   // �˾��޴�
   txtMemo.setBackground(Color.YELLOW);
  } 
  txtMemo.requestFocus();
 }
 
 public static void main(String[] args) {
  new MemoJang();
 }

}
package com.bige.simplechat;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleChat extends JFrame implements ActionListener {
	JPanel chatPanel; // �����������
	JTextArea displayArea; // ����������ʾ��
	JTextField inputText; // ���������ı���
	JButton startButton, stopButton;
	JLabel statusLabel;

	public SimpleChat() {
		super("һ�����׵�����ҳ��"); // �������
		setGUIComponent();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(chatPanel, BorderLayout.CENTER);
		getContentPane().add(statusLabel, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}

	public void setGUIComponent() {
		chatPanel = new JPanel();
		chatPanel.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		displayArea = new JTextArea(20, 40);
		displayArea.setEditable(false);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 6;
		constraints.gridheight = 4;
		chatPanel.add(new JScrollPane(displayArea), constraints);
		inputText = new JTextField(30);
		inputText.setEditable(false);
		inputText.addActionListener(this); // ע�ᵽ������
		constraints.gridwidth = 7;
		constraints.gridwidth = 1;
		constraints.gridy = GridBagConstraints.RELATIVE;
		chatPanel.add(inputText, constraints);

		startButton = new JButton("��ʼ����");
		startButton.addActionListener(this); // ע�ᵽ������
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.gridy = 10;
		chatPanel.add(startButton, constraints);

		stopButton = new JButton("��������");
		stopButton.setEnabled(false);
		stopButton.addActionListener(this); // ע�ᵽ������
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		constraints.gridx = GridBagConstraints.RELATIVE;
		chatPanel.add(stopButton, constraints);
		statusLabel = new JLabel("��ʼ��״̬");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			// ��������
			startButton.setEnabled(false);
			stopButton.setEnabled(true);
			inputText.setEditable(true);
			statusLabel.setText("����״̬");
		} else if (e.getSource() == stopButton) {
			// ֹͣ����
			startButton.setEnabled(true);
			stopButton.setEnabled(false);
			inputText.setEditable(false);
			statusLabel.setText("ֹͣ״̬");
		} else if (e.getSource() == inputText) {
			// �������ݵ�����
			displayArea.append(inputText.getText() + "\n");
			inputText.setText("");
		}
	}

	public static void main(String[] args) {
		SimpleChat scr = new SimpleChat();
		scr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
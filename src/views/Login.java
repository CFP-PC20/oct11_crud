package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;


import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

import db.Conexion;

public class Login {

	private JFrame frmAcceso;
	private JTextField txtUsuario;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAcceso.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcceso = new JFrame();
		frmAcceso.getContentPane().setBackground(Color.DARK_GRAY);
		frmAcceso.getContentPane().setLayout(null);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a: ");
		lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblPassword.setBounds(81, 101, 93, 20);
		frmAcceso.getContentPane().add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		
		JLabel label = new JLabel("Nombre:");
		label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		label.setBounds(81, 53, 93, 20);
		frmAcceso.getContentPane().add(label);
		label.setForeground(Color.WHITE);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUsuario.setBackground(Color.GRAY);
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setBounds(196, 52, 171, 26);
		frmAcceso.getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setForeground(Color.WHITE);
		txtPassword.setBackground(Color.GRAY);
		txtPassword.setBounds(196, 100, 171, 26);
		frmAcceso.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnAcceder = new JButton("Acceder");
		
		btnAcceder.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAcceder.setForeground(Color.WHITE);
		btnAcceder.setBackground(Color.GRAY);
		btnAcceder.setBounds(81, 156, 286, 53);
		frmAcceso.getContentPane().add(btnAcceder);
		frmAcceso.setTitle("Acceso");
		frmAcceso.setBounds(100, 100, 450, 300);
		frmAcceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acceder();
			}
		});
	}
	
	private void acceder () {
		Connection con = new Conexion().conectar();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE username=? AND password=?");
			ps.setString(1, txtUsuario.getText());
			ps.setString(2, txtPassword.getText());
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Principal p = new Principal();
				p.frmAcceso.setVisible(true);
			} else {
				
			}
			System.out.println(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

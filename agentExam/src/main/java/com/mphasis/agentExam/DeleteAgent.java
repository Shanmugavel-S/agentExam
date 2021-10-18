package com.mphasis.agentExam;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteAgent {

	public static void main(String[] args) {
		int agentId;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Agent id   ");
		agentId = sc.nextInt();
		AgentDAO dao = new AgentDAO();
		try {
			System.out.println(dao.deleteAgent(agentId));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package com.mphasis.agentExam;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentSearchMain {

	public static void main(String[] args) {
		int agentId;
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter Agent id   ");
		agentId = sc.nextInt();
		try {
			Agent agent = new AgentDAO().searchAgent(agentId);
			if (agent!=null) {
				System.out.println(agent);
			} else {
				System.out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

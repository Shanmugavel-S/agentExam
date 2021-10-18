package com.mphasis.agentExam;

import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAgentMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    Agent agent=new Agent();
		System.out.println("Enter Agent Id  ");
		agent.setAgentId(sc.nextInt());
		System.out.println("Enter agentName   ");
		agent.setName(sc.next());	
		System.out.println("Enter Gender   ");
		agent.setGender(sc.next());
		System.out.println("Enter city ");
		agent.setCity(sc.next());
		System.out.println("Enter martial status   ");
		agent.setMaritalStatus(sc.nextInt());
		System.out.println("Enter premium number  ");
		agent.setPremium(sc.nextInt());
		AgentDAO dao = new AgentDAO();
		try {
			System.out.println(dao.updateAgent(agent));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

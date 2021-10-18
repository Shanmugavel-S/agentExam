package com.mphasis.agentExam;

import java.sql.SQLException;

public class AgentShowAllMain {
	public static void main(String[] args) {
		AgentDAO dao = new AgentDAO();
		Agent[] arrAgent;
		try {
			arrAgent = dao.showAgent();
			for (Agent agent : arrAgent) {
				System.out.println(agent);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package com.mphasis.agentExam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {

	Connection connection;
	PreparedStatement pst;
	
	public String updateAgent(Agent agent) throws ClassNotFoundException, SQLException {
		Agent agentFound = searchAgent(agent.getAgentId());
		if (agentFound != null) {
			String cmd = "Update Agentexam set Name=?, Gender=?, City=?, MaritalStatus=?, Premium=? "
					+ " Where AgentId=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, agent.getName());
			pst.setString(2, agent.getGender());
			pst.setString(3, agent.getCity());
			pst.setInt(4, agent.getMaritalStatus()); 
			pst.setInt(5, agent.getPremium());
			pst.setInt(6, agent.getAgentId());
			pst.executeUpdate();
			return "Record Updated...";
		}
		return "Record Not Found...";
	}
	
	public String deleteAgent(int agentid) throws ClassNotFoundException, SQLException {
		Agent agent = searchAgent(agentid);
		if (agent != null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Delete from AgentExam where agentid=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, agentid);
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return "Record Not Found...";
	}
	
	public String addAgent(Agent agent) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into Agentexam(agentid,name,gender,city,maritalStatus,premium) "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agent.getAgentId());
		pst.setString(2, agent.getName());
		pst.setString(3, agent.getGender());
		pst.setString(4, agent.getCity());
		pst.setInt(5, agent.getMaritalStatus()); 
		pst.setInt(6, agent.getPremium());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	
	public Agent searchAgent(int agentid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Agentexam where agentid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentid);
		ResultSet rs = pst.executeQuery();
		Agent agent = null;
		if (rs.next()) {
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentid"));
			agent.setName(rs.getString("name"));
			agent.setGender(rs.getString("gender"));
			agent.setCity(rs.getString("city"));
			agent.setMaritalStatus(rs.getInt("maritalStatus"));
			agent.setPremium(rs.getInt("premium"));
		}
		return agent;
	}
	public Agent[] showAgent() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from agentExam";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Agent> agentList = new ArrayList<Agent>();
		Agent agent = null;
		while(rs.next()) {
			agent = new Agent();
			agent.setAgentId(rs.getInt("agentid"));
			agent.setName(rs.getString("name"));
			agent.setGender(rs.getString("gender"));
			agent.setCity(rs.getString("city"));
			agent.setMaritalStatus(rs.getInt("maritalStatus"));
			agent.setPremium(rs.getInt("premium"));
			agentList.add(agent);
		}
	    return agentList.toArray(new Agent[agentList.size()]);
	}
}

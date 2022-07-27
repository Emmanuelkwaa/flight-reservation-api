package com.skillstorm.flightreservationapi.services;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class AirplaneIdGenerator implements IdentifierGenerator {
    Random random = new Random();
    char[] alphabet = {'0', '1', '2', '3', '4', '5', '6','7','8', '9', 'A',
            'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q' , 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    int size = 6;

    String nanaId = NanoIdUtils.randomNanoId(random, alphabet, size);


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "cli";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(id) as Id from Airplane");

            if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = nanaId + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}

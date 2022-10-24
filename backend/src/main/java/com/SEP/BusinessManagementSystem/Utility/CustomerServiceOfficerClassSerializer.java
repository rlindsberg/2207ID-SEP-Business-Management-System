package com.SEP.BusinessManagementSystem.Utility;

import com.SEP.BusinessManagementSystem.Entity.CustomerServiceOfficer;
import com.SEP.BusinessManagementSystem.Entity.Role;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;


import java.io.IOException;

import java.io.IOException;


public class CustomerServiceOfficerClassSerializer extends StdSerializer<CustomerServiceOfficer> {

    protected CustomerServiceOfficerClassSerializer() {
        this(null);
    }

    protected CustomerServiceOfficerClassSerializer(Class<CustomerServiceOfficer> t) {
        super(t);
    }

    @Override
    public void serialize(CustomerServiceOfficer customerServiceOfficer, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeFieldName("id");
        jsonGenerator.writeNumber(customerServiceOfficer.getUserAsAppUser().getId());
        jsonGenerator.writeStringField("firstname", customerServiceOfficer.getUserAsAppUser().getFirstname());
        jsonGenerator.writeStringField("lastname", customerServiceOfficer.getUserAsAppUser().getLastname());
        jsonGenerator.writeStringField("email", customerServiceOfficer.getUserAsAppUser().getEmail());


        jsonGenerator.writeArrayFieldStart("roles");
        for(Role role : customerServiceOfficer.getUserAsAppUser().getRoles()){
            jsonGenerator.writeString(role.getName());
        }
        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();
    }
}

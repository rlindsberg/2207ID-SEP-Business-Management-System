package com.SEP.BusinessManagementSystem.Utility;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.SEP.BusinessManagementSystem.Entity.Role;

import java.io.IOException;
import java.util.Set;

public class RolesFieldSerializerInClassAppUser extends StdSerializer<Set<Role>> {

    protected RolesFieldSerializerInClassAppUser() {
        this(null);
    }

    protected RolesFieldSerializerInClassAppUser(Class<Set<Role>> t) {
        super(t);
    }

    @Override
    public void serialize(Set<Role> roles, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartArray("roles");
        for(Role role : roles){
            jsonGenerator.writeString(role.getName());
        }
        jsonGenerator.writeEndArray();
    }
}
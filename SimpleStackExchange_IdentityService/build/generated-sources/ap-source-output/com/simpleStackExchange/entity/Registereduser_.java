package com.simpleStackExchange.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-18T05:52:54")
@StaticMetamodel(Registereduser.class)
public class Registereduser_ { 

    public static volatile SingularAttribute<Registereduser, Integer> uid;
    public static volatile SingularAttribute<Registereduser, String> password;
    public static volatile SingularAttribute<Registereduser, Date> datetime;
    public static volatile SingularAttribute<Registereduser, String> name;
    public static volatile SingularAttribute<Registereduser, String> email;

}
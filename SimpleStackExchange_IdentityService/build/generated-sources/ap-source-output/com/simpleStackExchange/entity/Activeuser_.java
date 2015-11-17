package com.simpleStackExchange.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-18T05:52:54")
@StaticMetamodel(Activeuser.class)
public class Activeuser_ { 

    public static volatile SingularAttribute<Activeuser, Date> createdTime;
    public static volatile SingularAttribute<Activeuser, Integer> userId;
    public static volatile SingularAttribute<Activeuser, String> token;

}
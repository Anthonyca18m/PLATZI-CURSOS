package com.platzi.platzi_play.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {

    @Named("StringToBoolean")
    public static Boolean StringToBoolean(String estado)
    {
        return estado.equals("D");
    }

}

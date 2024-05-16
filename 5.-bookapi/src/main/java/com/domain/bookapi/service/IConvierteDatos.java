package com.domain.bookapi.service;

public interface IConvierteDatos {

    <T> T obtenerDatos(String json, Class<T> clase);

}

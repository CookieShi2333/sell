package com.wece.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * sell
 * com.wece.serializer
 * Created by liaowj on 2018/12/24.
 * Description:
 *
 * @version 1.0
 */
public class DateToLongSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getTime() / 1000);
    }
}

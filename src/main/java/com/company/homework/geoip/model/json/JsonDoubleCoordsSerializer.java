package com.company.homework.geoip.model.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class JsonDoubleCoordsSerializer extends JsonSerializer<Double> {

    private final String doubleCoordsPattern = "#.000000";
    private final DecimalFormat doubleCoordsFormat = new DecimalFormat(doubleCoordsPattern, new DecimalFormatSymbols(Locale.US));

    /* Formats double to be converted into string with trailing zeroes for up to 6 digits
     */
    @Override
    public void serialize(Double aDouble, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(doubleCoordsFormat.format(aDouble));
    }
}

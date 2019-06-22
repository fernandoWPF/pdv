package br.com.pdv.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import br.com.pdv.configuracao.Propriedades;

public class LocalDateUtils {

    private static final String CHAVE_ZONE_ID = "zone.id";
    private static final String CHAVE_FORMATO_DATA_HORA = "formato.data.hora";
    private static final String CHAVE_FORMATO_DATA = "formato.data";

    private LocalDateUtils() {
        throw new IllegalStateException("Classe utilitaria. Não deve ser instanciada.");
    }

    public static LocalDateTime toLocalDateTimeComTimeZone(LocalDateTime localDateTime) {
        return Objects.nonNull(localDateTime) ? LocalDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.UTC),
                ZoneId.of(Propriedades.getConfiguracoes().get(CHAVE_ZONE_ID))) : null;
    }

    public static String formatarLocalDateTime(LocalDateTime value) {
        DateTimeFormatter formatter = getDateTimeFormatter(CHAVE_FORMATO_DATA_HORA);
        return Objects.nonNull(value) ? value.format(formatter) : null;
    }

    public static String formatarLocalDate(LocalDate value) {
        DateTimeFormatter formatter = getDateTimeFormatter(CHAVE_FORMATO_DATA);
        return Objects.nonNull(value) ? value.format(formatter) : null;
    }

    private static DateTimeFormatter getDateTimeFormatter(String chave) {
        return DateTimeFormatter.ofPattern(Propriedades.getConfiguracoes().get(chave));
    }
}

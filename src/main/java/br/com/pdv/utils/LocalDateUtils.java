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
    private static final String ZONE_ID_DEFAULT = "America/Sao_Paulo";
    private static final String CHAVE_FORMATO_DATA_HORA = "formato.data.hora";
    private static final String CHAVE_FORMATO_DATA = "formato.data";
    private static final String FORMATO_DATA_HORA_DEFAULT = "dd/mm/yyyy HH:mm:ss.SSSS";
    private static final String FORMATO_DATA_DEFAULT = "dd/mm/yyyy";

    private LocalDateUtils() {
        throw new IllegalStateException("Classe utilitaria. Não deve ser instanciada.");
    }

    public static LocalDateTime toLocalDateTimeComTimeZone(LocalDateTime localDateTime) {
        String config = Propriedades.get(CHAVE_ZONE_ID);
        if (Objects.isNull(localDateTime)) {
            return null;
        }
        return LocalDateTime.ofInstant(localDateTime.toInstant(ZoneOffset.UTC),
                ZoneId.of(Objects.nonNull(config) ? config : ZONE_ID_DEFAULT));
    }

    public static String formatarLocalDateTime(LocalDateTime value) {
        DateTimeFormatter formatter = getDateTimeFormatter(CHAVE_FORMATO_DATA_HORA, FORMATO_DATA_HORA_DEFAULT);
        return Objects.nonNull(value) ? value.format(formatter) : null;
    }

    public static String formatarLocalDate(LocalDate value) {
        DateTimeFormatter formatter = getDateTimeFormatter(CHAVE_FORMATO_DATA, FORMATO_DATA_DEFAULT);
        return Objects.nonNull(value) ? value.format(formatter) : null;
    }

    private static DateTimeFormatter getDateTimeFormatter(String chave, String patternDefault) {
        String config = Propriedades.get(chave);
        return DateTimeFormatter.ofPattern(Objects.nonNull(config) ? config : patternDefault);
    }
}

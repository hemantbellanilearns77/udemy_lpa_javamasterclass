package com.hb.study.libs.datetimeutillib.core;

/**
 * created by : heman on 14-07-2025, 06:39 pm, in the "udemy_lpa_javamasterclass" project
 **/

import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

public class ZoneLibrary {

    public static List<ZoneId> getGlobalZones() {
        return ZoneId.getAvailableZoneIds().stream()
                .map(ZoneId::of)
                .collect(Collectors.toList());
    }
}
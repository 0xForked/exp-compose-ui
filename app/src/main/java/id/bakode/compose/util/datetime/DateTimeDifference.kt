package id.bakode.compose.util.datetime

import id.bakode.compose.util.enums.TimeDifference

class DateTimeDifference {
    fun calculate(
        currentTime: Long,
        previousTime: Long,
        timeDifference: TimeDifference
    ): Long {
        return when (timeDifference.timeDifference) {
            //DIFFERENCE WITH SECONDS
            0 -> (currentTime - previousTime) / 1000
            //DIFFERENCE WITH MINUTES
            1 -> (currentTime - previousTime) / 1000 / 60
            //DIFFERENCE WITH HOURS
            2 -> (currentTime - previousTime) / 1000 / 60 / 60
            //DIFFERENCE WITH DAYS
            3 -> (currentTime - previousTime) / 1000 / 60 / 60 / 24
            //DIFFERENCE WITH MONTHS
            4 -> (currentTime - previousTime) / 1000 / 60 / 60 / 24 / 30
            //GETTING DIFFERENCE WITH YEARS
            else -> (currentTime - previousTime) / 1000 / 60 / 60 / 24 / 30 / 365
        }
    }
}
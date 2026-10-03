package com.automationanywhere.botcommand.commands;

import java.time.ZonedDateTime;
import java.time.ZoneOffset;

import com.automationanywhere.botcommand.data.impl.DateTimeValue;
import com.automationanywhere.commandsdk.annotations.BotCommand;
import com.automationanywhere.commandsdk.annotations.CommandPkg;
import com.automationanywhere.commandsdk.annotations.Execute;
import com.automationanywhere.commandsdk.model.DataType;

/**
 * This command returns the current UTC DateTime.
 * 
 */
@BotCommand
@CommandPkg(
        name = "GetCurrentUtcTime",
        label = "Get current UTC time",
        node_label = "current UTC time to variable",
        description = "Returns the current UTC DateTime",
        return_required = true,
        return_label = "UTC DateTime",
        //return_description = "UTC timezone",
        return_name = "currentUtcDateTime",
        return_type = DataType.DATETIME,
        return_Direct = true,
        documentation_url = "",
        icon = "calendar_icon.png"
)

public class GetCurrentUtcDateTime {

    @Execute
    public DateTimeValue action(

    ) {

        DateTimeValue output = new DateTimeValue();

        // Get current UTC time
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);

        output.set(utcNow);

        // Return value to AA variable
        return output;
    }
}

package commands;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationanywhere.botcommand.commands.GetCurrentUtcDateTime;
import com.automationanywhere.botcommand.data.impl.DateTimeValue;

public class Test_GetCurrentUtcDateTime {

    private GetCurrentUtcDateTime command;

    @BeforeClass
    public void setup() {
        command = new GetCurrentUtcDateTime();
    }

    @Test
    public void testGetUtcDateTime_NotNull() {
        DateTimeValue result = command.action();
        Assert.assertNotNull(result, "UTC DateTime should not be null");
        Assert.assertNotNull(result.get(), "Underlying ZonedDateTime should not be null");
    }

    @Test
    public void testGetUtcDateTime_IsUTC() {
        DateTimeValue result = command.action();
        ZonedDateTime dateTime = result.get();

        Assert.assertEquals(
            dateTime.getOffset(),
            ZoneOffset.UTC,
            "Timezone should be UTC"
        );
    }

    @Test
    public void testGetUtcDateTime_IsRecent() {
        ZonedDateTime beforeCall = ZonedDateTime.now(ZoneOffset.UTC);

        DateTimeValue result = command.action();
        ZonedDateTime dateTime = result.get();

        ZonedDateTime afterCall = ZonedDateTime.now(ZoneOffset.UTC);

        Assert.assertTrue(
            (dateTime.isEqual(beforeCall) || dateTime.isAfter(beforeCall)) &&
            (dateTime.isEqual(afterCall) || dateTime.isBefore(afterCall)),
            "Result should be between before and after timestamps"
        );
    }
    
}

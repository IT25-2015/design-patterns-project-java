package logparser.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;

import logparser.CommandParser;

public class CommandParserTest {

	@Test
	public void testIfSingletonInstanceIsReturned() {
		assertTrue(CommandParser.getInstance() instanceof CommandParser);
	}
}

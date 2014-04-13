Feature: Start and stop

	Scenario: Terminate on exit command

		Given the application receives an 'exit' command
		Then the application should terminate
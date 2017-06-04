Feature: User's wall

	Background:

	In order to see what all my friends are up to
	As a user
	I would like to follow them and see all their messages

	Scenario: User sees messages from friends on her own wall

		Given Bob posts a few messages
		And Charlie posts a few messages
		And Charlie follows Bob
		When Charlie checks his wall
		Then messages from Bob and Charlie are displayed in reverse chronological order
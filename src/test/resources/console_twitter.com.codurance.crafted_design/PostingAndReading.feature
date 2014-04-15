Feature: Posting and Reading

	Background:

	In order to share my ideas with the world
	As a user
	I would like to post my messages so other people could read them

	Scenario: Reading posts from a user

		Given Alice posts a few messages

		When Bob reads Alice's messages

		Then Alice's messages are displayed in reverse chronological order

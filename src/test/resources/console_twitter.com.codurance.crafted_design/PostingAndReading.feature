Feature: Posting and Reading

	Background:

	In order to share my ideas with the world
	As a user
	I would like to post my messages so other people could read them

	Scenario: Reading posts from a user

		Given Alice posts a few messages

		When Bob reads Alice's messages

		Then Alice's messages are displayed in reverse chronological order

#info("In order to share my ideas with the world")
#info("As a user")
#info("I would like to post my messages")
#info("And make them available so other users could read them")
#
#Given("Alice posts messages")
#twitter willReceive "Alice -> Hello, my name is Alice"
#twitter willReceive "Alice -> It's a lovely day today"
#
#When("Bob reads Alice's messages")
#twitter willReceive "Alice"
#
#Then("Alice's messages are displayed in reverse-chronological order")
#twitter outputFor(twitter userCommands) should matchOutput(
#"> " +
#"> " +
#"> " +
#"Alice - It's a lovely day today \n" +
#"Alice - Hello, my name is Alice \n" +
#"> bye!\n")

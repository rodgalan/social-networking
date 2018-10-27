# Social Networking Kata
Based on [https://github.com/sandromancuso/social_networking_kata]( https://github.com/sandromancuso/social_networking_kata).

I change original command-line requirement for an API interface. 

Just for test myself in outside-in mockist TDD and try to start with acceptance tests against a non existent API ;-)

## Goal 
Implement an API for a social networking application (similar to Twitter) satisfying the scenarios below.

## Scenarios

Posting: Alice can publish messages to a personal timeline

    > Alice -> I love the weather today
    > Bob -> Damn! We lost!
    > Bob -> Good game though.

Reading: Bob can view Alice’s timeline

    > Alice
    > I love the weather today (5 minutes ago)
    > Bob
    > Good game though. (1 minute ago)
    > Damn! We lost! (2 minutes ago)

Following: Charlie can subscribe to Alice’s and Bob’s timelines, and view an aggregated list of all subscriptions

    > Charlie -> I'm in New York today! Anyone wants to have a coffee?
    > Charlie follows Alice
    > Charlie wall
    > Charlie - I'm in New York today! Anyone wants to have a coffee? (2 seconds ago)
    > Alice - I love the weather today (5 minutes ago)

    > Charlie follows Bob
    > Charlie wall
    > Charlie - I'm in New York today! Anyone wants to have a coffee? (15 seconds ago)
    > Bob - Good game though. (1 minute ago)
    > Bob - Damn! We lost! (2 minutes ago)
    > Alice - I love the weather today (5 minutes ago)

## General requirements

    Application must use an API for input and output:
        Endpoint for posting: POST to /user/<user name>/post
        Endpoint for reading: GET to /read?username=<user name>
        Endpoint for following: POST to /user/<user name>/follow/<another name>
        Endpoint for wall: GET to /user/<user name>/wall



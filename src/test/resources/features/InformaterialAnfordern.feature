@infoAnfodern
Feature: As a user I have to register anf fill the form

  #it is our pre-condition and user is already on "Infomaterial Page"
  Background: As a user I am on the "Infomaterial anfordern" page
    Given As a user I am on "Infomaterial anfordern" page

  @AC-1 @AC-2
  Scenario: User should see the "Infomaterial anfordern" tab ant title
    Then the user should see the "Infomaterial anfordern" tab
    And the user should see "Infomaterial anfordern" as title
    And the headline of page should be "Infomaterial anfordern"

  @AC-3
  Scenario: the "Themen" inside should be selectable
    Then the all Themen should be visible and selectable
      | Privatabrechnung      |
      | Patienten-Teilzahlung |
      | Finanzierung          |
      | Geldanlage            |
      | Tagesgeld             |
      | Festgeld              |
    And the user should able to select "Geldanlage" thema

  @AC-4
  Scenario: User should able to select a profession
    Then the all professions in dropdown should be selectable
      | Arzt/Ärztin                |
      | Zahnarzt/Zahnärztin        |
      | Chefarzt/Chefärztin        |
      | Vertreter/-in einer Klinik |
      | Heilpraktiker/-in          |
      | Sonstige Heilberufe        |
    And the select of profession from user should be required
    And the user should able to select "Zahnarzt/Zahnärztin" option from profession

  @AC-5
  Scenario: User should able to select from Aufmerksam dropdown
    Then the all option in Aufmerksam dropdown should be selectable
      | Empfehlung            |
      | Onlinewerbung         |
      | per E-Mail            |
      | Werbung per Post      |
      | Fachmagazin / Zeitung |
      | Veranstaltungen       |
      | Social Media          |
    And the select of Aufmerksam option from user should be required
    And the user should able to select "Veranstaltungen" option from Aufmerksam

  @AC-6
  Scenario: System should require from user personal details
    Then the all mandatory inputs should have asterisk signs
    And the all mandatory input labels should be visible
      | Vorname*             |
      | Nachname*            |
      | Straße & Hausnummer* |
      | PLZ*                 |
      | Ort*                 |
      | E-Mail*              |
    And the all asterisk signed labels input should be require data from user

  @AC-7
  Scenario: User has to be checked mandatory checkboxes on form
    Then User should be able to accept the following checkboxes
      | Datenschutzbestimmungen* |
      | Infomaterial anfordern*  |

  @AC-8
  Scenario: verify that user can see "Kostenloses Infomaterial anfordern" button
    Then the user should see "Kostenloses Infomaterial anfordern" "#004487" in blue color
    And the button should be enable













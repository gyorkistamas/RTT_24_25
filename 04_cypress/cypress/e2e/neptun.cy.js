/// <reference types="cypress" />

describe('Neptun tesztelése', () => {
  it('tries to log in to Neptun but fails', () => {
    cy.visit('https://neptun.uni-eszterhazy.hu');
    cy.contains("Hallgatók").click();
    cy.get('#linkStudentvolt').invoke('removeAttr', 'target').click();
    cy.get('#user').type("ABC123");
    cy.get('#pwd').type("asdasd123");
    cy.get('#btnSubmit').click();
    cy.contains('Érvénytelen').should('be.visible');
  })
})
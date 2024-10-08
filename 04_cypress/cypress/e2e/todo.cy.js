/// <reference types="cypress" />

describe('Testing To-do app', () => {
  beforeEach(() =>{
    cy.visit("https://example.cypress.io/todo")
  });

  it('displays two item in the list', () => {
    cy.get('.todo-list li').should('have.length', 2);
    cy.get('.todo-list li').first().should('have.text', 'Pay electric bill');
    cy.get('.todo-list li').last().should('have.text', 'Walk the dog');
  })

  it('can add a new element to the list', () => {
    const newItem = 'Feed the dog';

    cy.get('[data-test=new-todo]').type(`${newItem}{enter}`);

    cy.get('.todo-list li')
    .should('have.length', 3)
    .last()
    .should('have.text', newItem);

  });

})
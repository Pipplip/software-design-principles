package de.phbe

import de.phbe.lawofdemeter.LawOfDemeterLOD
import de.phbe.solid.DependencyInversionDIP
import de.phbe.solid.InterfaceSegregationISP
import de.phbe.solid.LiskovSubstitutionLSP
import de.phbe.solid.OpenClosedPrincipleOCP
import de.phbe.solid.SingleResponsibilitySRP

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // SRP
    println("--- Single Responsibility Principle (SRP) ---")
    val singleResponsibility = SingleResponsibilitySRP()
    singleResponsibility.showPrinciple()

    // OCP
    println("--- Open Closed Principle (OCP) ---")
    val openClosedPrincipleOCP = OpenClosedPrincipleOCP()
    openClosedPrincipleOCP.showPrinciple()

    // LSP
    println("--- Liskov Substitution Principle (LSP) ---")
    val liskovSubstitutionLSP = LiskovSubstitutionLSP()
    liskovSubstitutionLSP.showPrinciple()

    // ISP
    println("--- Interface Segregation Principle (ISP) ---")
    val interfaceSegregation = InterfaceSegregationISP()
    interfaceSegregation.showPrinciple()

    // DIP
    println("--- Dependency Inversion Principle (DIP) ---")
    val dependencyInversionDIP = DependencyInversionDIP()
    dependencyInversionDIP.showPrinciple()

    // LOD
    println("--- Law of Demeter (LOD) ---")
    val lawOfDemeter = LawOfDemeterLOD()
    lawOfDemeter.showPrinciple()
}
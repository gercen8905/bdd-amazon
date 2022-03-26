Feature: Test Search feature on amazon site with different inputs

  Scenario Outline: test amazon site for search with different inputs
    Given user opens the amazon site

    When user enters "<input>"

    Then searched product should be displayed in search results
    And found products should contain input
    Examples:
      | input  |

      | laptop |

      | car    |

      | mouse  |

      | cat    |


  Scenario Outline: test amazon site for search with incorrect inputs
    Given user opens the amazon site

    When user enters "<input>"

    Then incorrect input should return no results
    Examples:
      | input                           |
      | qwe4t5et6789tz3js4jdm1234567890 |
      | piano                           |


  Scenario Outline: test amazon site for search with different inputs
    Given user opens the amazon site

    When user enters "<input>"
    And user navigates to the next page of results

    Then searched product should be displayed in search results
    Examples:
      | input  |

      | world  |

      | bag    |

      | printer  |

      | tablet    |


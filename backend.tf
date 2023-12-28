terraform {
  backend "azurerm" {
    resource_group_name  = "rg-common-001-poc"
    storage_account_name = "sacommon002poc"
    container_name       = "tfstate"
    key                  = "terraform.tfstate"
  }
}
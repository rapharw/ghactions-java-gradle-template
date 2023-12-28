variable "AZURE_RG" {
  type = string
}

variable "AZURE_LOCATION" {
  type = string
}
variable "AZURE_ASP_NAME" {
  type = string
}

variable "AZURE_ASP_SKU_SIZE" {
  type = string
}

variable "AZURE_ASP_SO" {
  type = string
}

variable "AZURE_APP_NAME" {
  type = string
}

variable "CONTAINER_REGISTRY_USERNAME" {
  type = string
}

variable "CONTAINER_REGISTRY_REPO_NAME" {
  type = string
}


variable "CONTAINER_IMAGE_TAG" {
  type = string
}

variable "CONTAINER_REGISTRY_TOKEN" {
  type = string
}


# Configure the Azure provider
provider "azurerm" {
  features {}
}

# Azure App Service Plan
resource "azurerm_service_plan" "app_service_plan" {

  name                = var.AZURE_ASP_NAME
  location            = var.AZURE_LOCATION
  resource_group_name = var.AZURE_RG

  os_type  = var.AZURE_ASP_SO
  sku_name = var.AZURE_ASP_SKU_SIZE

}

# Azure App Service (Web App for Containers)
resource "azurerm_linux_web_app" "app_service" {
  name                = var.AZURE_APP_NAME
  location            = var.AZURE_LOCATION
  resource_group_name = var.AZURE_RG
  service_plan_id = azurerm_service_plan.app_service_plan.id

  app_settings = {
    "WEBSITES_PORT" = "8080"
  }

  site_config {
    always_on              = true
    app_command_line       = ""
    remote_debugging_enabled = false

    application_stack {
      docker_registry_url = "https://ghcr.io"
      docker_image = "${var.CONTAINER_REGISTRY_USERNAME}/${var.CONTAINER_REGISTRY_REPO_NAME}"
      docker_image_tag = var.CONTAINER_IMAGE_TAG
      docker_registry_username = var.CONTAINER_REGISTRY_USERNAME
      docker_registry_password = var.CONTAINER_REGISTRY_TOKEN
    }
  }

}
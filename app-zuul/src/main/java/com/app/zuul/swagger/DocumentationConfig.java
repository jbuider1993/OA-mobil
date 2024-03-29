package com.app.zuul.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@ConditionalOnProperty(name = "enabled", prefix = "swagger", havingValue = "true", matchIfMissing = true)
public class DocumentationConfig implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		// 以下二选一
		// 1.可访问所有的接口
		// List<SwaggerResource> resources = new ArrayList<>();
		// List<Route> routes = routeLocator.getRoutes();
		// // 在这里遍历的时候，可以排除掉敏感微服务的路由
		// routes.forEach(route -> resources.add(swaggerResource(route.getId(),
		// route.getFullPath().replace("**", "v2/api-docs"), "2.0")));
		// 2.访问指定接口
		List<SwaggerResource> resources = new ArrayList<>();
        resources.add(swaggerResource("API权限接口", "/app/v2/api-docs", "2.0"));
        resources.add(swaggerResource("售后服务API接口", "/seal/v2/api-docs", "2.0"));
		return resources;
	}

	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}
}

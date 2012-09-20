package uk.ac.lancs.sakai.nonlusiservice.entityprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sakaiproject.entitybroker.DeveloperHelperService;
import org.sakaiproject.entitybroker.EntityReference;
import org.sakaiproject.entitybroker.entityprovider.CoreEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.capabilities.AutoRegisterEntityProvider;
import org.sakaiproject.entitybroker.entityprovider.capabilities.CollectionResolvable;
import org.sakaiproject.entitybroker.entityprovider.capabilities.Outputable;
import org.sakaiproject.entitybroker.entityprovider.extension.Formats;
import org.sakaiproject.entitybroker.entityprovider.search.Search;
import org.sakaiproject.entitybroker.util.AbstractEntityProvider;
import org.sakaiproject.site.api.Site;
import org.sakaiproject.site.api.SiteService;
import org.sakaiproject.site.api.SiteService.SelectionType;
import org.sakaiproject.site.api.SiteService.SortType;

import uk.ac.lancs.sakai.nonlusiservice.Module;

public class ModuleProvider extends AbstractEntityProvider implements CoreEntityProvider, AutoRegisterEntityProvider, Outputable, CollectionResolvable {

	private SiteService siteService;
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	private DeveloperHelperService developerService = null;
	public void setDeveloperService(DeveloperHelperService developerService) {
		this.developerService = developerService;
	}

	public final static String ENTITY_PREFIX = "non-lusi-modules";

	public boolean entityExists(String id) {
        return true;
	}

	public Object getEntity(EntityReference ref) {
        return null;
	}

	public Object getSampleEntity() {
		return new Module();
	}

	public String getEntityPrefix() {
		return ENTITY_PREFIX;
	}

	public String[] getHandledOutputFormats() {
		return new String[] { Formats.JSON };
	}

	public List<Module> getEntities(EntityReference ref, Search search) {
		List<Module> modules = new ArrayList<Module>();
		
		Map<String,String> criteria = new HashMap<String,String>(1);
		
		criteria.put("from-lusi", "no");
		
		List<Site> sites = siteService.getSites(SelectionType.ANY, null, null, criteria, SortType.NONE, null);
		
		for(Site site : sites) {
			String siteId = site.getId();
			String[] parts = siteId.split("-");
			String moduleId = parts[0];
			String yearId = parts[1];
			modules.add(new Module(siteId,site.getTitle(),site.getUrl(),moduleId,yearId));
		}
		
		return modules;
	}
}

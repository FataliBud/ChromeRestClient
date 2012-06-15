/*******************************************************************************
 * Copyright 2012 Paweł Psztyć
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.rest.client;

import org.rest.client.storage.store.FormEncodingsStore;
import org.rest.client.storage.store.HeadersStore;
import org.rest.client.storage.store.HistoryRequestStore;
import org.rest.client.storage.store.LocalStore;
import org.rest.client.storage.store.ProjectsStore;
import org.rest.client.storage.store.RequestDataStore;
import org.rest.client.storage.store.StatusesStore;
import org.rest.client.storage.store.UrlHistoryStore;
import org.rest.client.ui.AboutView;
import org.rest.client.ui.AddEncodingView;
import org.rest.client.ui.JSONHeadersView;
import org.rest.client.ui.MenuItemView;
import org.rest.client.ui.MenuItemView.Presenter;
import org.rest.client.ui.MenuView;
import org.rest.client.ui.RequestView;
import org.rest.client.ui.SaveRequestDialogView;
import org.rest.client.ui.SettingsView;
import org.rest.client.ui.ShortcutView;
import org.rest.client.ui.desktop.AboutViewImpl;
import org.rest.client.ui.desktop.AddEncodingViewImpl;
import org.rest.client.ui.desktop.JSONHeadersViewImpl;
import org.rest.client.ui.desktop.MenuItemViewImpl;
import org.rest.client.ui.desktop.MenuViewImpl;
import org.rest.client.ui.desktop.RequestViewImpl;
import org.rest.client.ui.desktop.SaveRequestDialogViewImpl;
import org.rest.client.ui.desktop.SettingsViewImpl;
import org.rest.client.ui.desktop.ShortcutViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {
	
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static RequestView requestView = null;
	private static AboutView aboutView = null;
	private static MenuView menu = null;
	private static SettingsView settingsView = null;
	private static LocalStore latestRequestStore = null;
	private static RequestDataStore requestDataStore = null;
	private static HistoryRequestStore historyRequestStore = null;
	private static FormEncodingsStore formEncodingsStore = null;
	private static UrlHistoryStore urlHistoryStore = null;
	private static HeadersStore headersStore = null;
	private static StatusesStore statusesStore = null; 
	private static ProjectsStore projectsStore = null;
	
	@Override
	public EventBus getEventBus() {
		return eventBus;
	}
	
	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public RequestView getRequestView() {
		if(requestView == null){
			requestView = GWT.create(RequestViewImpl.class);
		}
		return requestView;
	}

	@Override
	public MenuView getMenuView() {
		if(menu == null){
			menu = new MenuViewImpl();
		}
		return menu;
	}

	@Override
	public MenuItemView createMenuItem(Presenter presenter) {
		MenuItemViewImpl menu = GWT.create(MenuItemViewImpl.class);
		menu.setPresenter(presenter);
		return menu;
	}

	@Override
	public LocalStore getLocalStore() {
		if(latestRequestStore == null){
			latestRequestStore = GWT.create(LocalStore.class);
		}
		return latestRequestStore;
	}

	@Override
	public RequestDataStore getRequestDataStore() {
		if(requestDataStore == null){
			requestDataStore = GWT.create(RequestDataStore.class);
		}
		return requestDataStore;
	}

	@Override
	public HistoryRequestStore getHistoryRequestStore() {
		if(historyRequestStore == null){
			historyRequestStore = GWT.create(HistoryRequestStore.class);
		}
		return historyRequestStore;
	}
	
	@Override
	public ProjectsStore getProjectsStore() {
		if(projectsStore == null){
			projectsStore = GWT.create(ProjectsStore.class);
		}
		return projectsStore;
	}
	

	@Override
	public AddEncodingView getAddEncodingView(EventBus eventBus) {
		AddEncodingView dialog = GWT.create(AddEncodingViewImpl.class);
		dialog.setEventBus(eventBus);
		return dialog;
	}

	@Override
	public FormEncodingsStore getFormEncodingsStore() {
		if(formEncodingsStore == null){
			formEncodingsStore = GWT.create(FormEncodingsStore.class);
		}
		return formEncodingsStore;
	}
	
	@Override
	public UrlHistoryStore getUrlHistoryStore(){
		if(urlHistoryStore == null){
			urlHistoryStore = GWT.create(UrlHistoryStore.class);
		}
		return urlHistoryStore;
	}

	@Override
	public HeadersStore getHeadersStore() {
		if(headersStore == null){
			headersStore = GWT.create(HeadersStore.class);
		}
		return headersStore;
	}

	@Override
	public StatusesStore getStatusesStore() {
		if(statusesStore == null){
			statusesStore = GWT.create(StatusesStore.class);
		}
		return statusesStore;
	}

	@Override
	public AboutView getAboutView() {
		if(aboutView == null){
			aboutView = GWT.create(AboutViewImpl.class);
		}
		return aboutView;
	}

	@Override
	public SettingsView getSettingsView() {
		if(settingsView == null){
			settingsView = GWT.create(SettingsViewImpl.class);
		}
		return settingsView;
	}

	@Override
	public JSONHeadersView getJSONHeadersView() {
		return GWT.create(JSONHeadersViewImpl.class);
	}

	@Override
	public ShortcutView getShortcutView() {
		return GWT.create(ShortcutViewImpl.class);
	}

	@Override
	public SaveRequestDialogView getSaveRequestDialogView() {
		return GWT.create(SaveRequestDialogViewImpl.class);
	}
}
/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.hadoop.store.strategy.naming;

import org.apache.hadoop.fs.Path;

/**
 * A {@code FileNamingStrategy} which simply uses a rolling counter to give unique file name.
 *
 * @author Janne Valkealahti
 *
 */
public class RollingFileNamingStrategy extends AbstractFileNamingStrategy {

	private int counter = 0;

	@Override
	public Path resolve(Path path) {
		if (path != null) {
			return new Path(path.getParent(), path.getName() + Integer.toString(counter));
		}
		else {
			return new Path(Integer.toString(counter));
		}
	}

	@Override
	public void reset() {
		counter++;
	}

}

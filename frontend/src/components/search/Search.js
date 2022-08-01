export const Search = () => {
  return (
    <div class="container mt-5">
      <div class="row d-flex justify-content-center">
        <div class="col-md-10">
          <div class="card p-3  py-4">
            <h5>An Easier way to find your Housing</h5>

            <div class="row g-3 mt-2">
              <div class="col-md-3">
                <div class="dropdown">
                  <button
                    class="btn btn-secondary dropdown-toggle"
                    type="button"
                    id="dropdownMenuButton"
                    data-toggle="dropdown"
                    aria-expanded="false"
                  >
                    Any Status
                  </button>
                  <ul
                    class="dropdown-menu"
                    aria-labelledby="dropdownMenuButton"
                  >
                    <li>
                      <a class="dropdown-item" href="#">
                        Rural
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        Urban
                      </a>
                    </li>
                    <li>
                      <a class="dropdown-item" href="#">
                        All
                      </a>
                    </li>
                  </ul>
                </div>
              </div>

              <div class="col-md-6">
                <input
                  type="text"
                  class="form-control"
                  placeholder="Enter address e.g. street, city and state or zip"
                />
              </div>

              <div class="col-md-3">
                <button class="btn btn-secondary btn-block">
                  Search Results
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

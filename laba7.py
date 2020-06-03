import numpy as np
from concurrent.futures import ProcessPoolExecutor, as_completed
from pi import pi

def calc_mp(f, n_jobs, n_iter):
    executor = ProcessPoolExecutor(max_workers=n_jobs)
    
    fs = [executor.submit(f,n_iter=n_iter // n_jobs) for _ in range(n_jobs)]
    return sum(f.result() for f in as_completed(fs)) / 250000000.0

calc_mp(pi, 4, 10**9)